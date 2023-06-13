/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.jar.track.lg;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luisj
 */
public class Executavel {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira seu login:");

        String login = leitor.next();
        System.out.println("Insira sua senha:");
        String senha = leitor.next();

        FuncionarioService funcDao = new FuncionarioService();
        API api = new API();

        if (!funcDao.login(login, senha).isEmpty()) {
            System.out.println("Login realizado!");
            Looca looca = new Looca();
            MaquinaService maquinaService = new MaquinaService();
            RedeService redeDao = new RedeService();
            Rede rede = looca.getRede();

            Double frequenciaCpu = Double.valueOf(api.getProcessador().getFrequencia());
            frequenciaCpu = frequenciaCpu / 2000000000.00;

            Double capRam = Double.valueOf(api.getMemoria().getTotal());
            capRam = capRam / 3073741824.00;

            Double capDisco = Double.valueOf(api.getDisco().get(0).getTamanho());
            capDisco = capDisco / 3073741824.00;

            Double leituraDisco = Double.valueOf(api.getDisco().get(0).getBytesDeLeitura());
            leituraDisco = leituraDisco / 200000000.00;

            Double escritaDisco = Double.valueOf(api.getDisco().get(0).getBytesDeEscritas());
            escritaDisco = escritaDisco / 200000000.00;

            List<Maquina> hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());
            List<RedeInterface> redes = new ArrayList();
            if (hostname.isEmpty()) {

                for (int i = 0; i < rede.getGrupoDeInterfaces().getInterfaces().size(); i++) {

                    if (!rede.getGrupoDeInterfaces().getInterfaces().get(i).getEnderecoIpv4().isEmpty() && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesRecebidos() > 0 && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesEnviados() > 0) {

                        redes.add(rede.getGrupoDeInterfaces().getInterfaces().get(i));

                    }
                }

                Maquina maquina = new Maquina(null, rede.getParametros().getHostName(), 1, api.getProcessador().getNome(), frequenciaCpu, "Memoria", capRam, api.getDisco().get(0).getModelo(), capDisco, leituraDisco, escritaDisco, funcDao.retornarFkEmpresa(login, senha));

                maquinaService.salvarMaquina(maquina);

                hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());
                System.out.println("Hostname do for do lgin: " + hostname);
                Redes redesCadastrar = new Redes(null, redes.get(0).getNome(), redes.get(0).getNomeExibicao(), redes.get(0).getEnderecoIpv4().get(0), redes.get(0).getEnderecoMac(), hostname.get(0).getIdMaquina());
                redeDao.cadastrarRede(redesCadastrar);
            } else {

                System.out.println("Maquina Ja cadastrada ou houve algum erro");

                LogService logService = new LogService();
                JanelaGrupo janelaGrupo = looca.getGrupoDeJanelas();
                DiscoGrupo disco = looca.getGrupoDeDiscos();



                //Frequncia do processador convertida para GHz
                Double usoDisco = Double.valueOf(api.getDisco().get(0).getTamanho() - disco.getVolumes().get(0).getDisponivel());
                usoDisco = usoDisco / 1073741824.00;

                //Uso da ram to GB
                Double usoRam = Double.valueOf(api.getMemoriaEmUso());
                usoRam = usoRam / 1073741824.00;

                Double finalUsoDisco1 = usoDisco;
                Double finalUsoRam1 = usoRam;
                new Timer()
                        .scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println("Dentro do timertask");
                                List<String> janelas = new ArrayList();
                                List<Long> janelasPid = new ArrayList();
                                for (int i = 0; i < janelaGrupo.getTotalJanelasVisiveis(); i++) {
                                    if (janelaGrupo.getJanelasVisiveis().get(i).getTitulo().length() > 0) {
                                        janelas.add(janelaGrupo.getJanelasVisiveis().get(i).getTitulo());
                                        janelasPid.add(janelaGrupo.getJanelasVisiveis().get(i).getPid());
                                    }
                                }
                                List<RedeInterface> redes = new ArrayList<>();

                                for (int i = 0; i < rede.getGrupoDeInterfaces().getInterfaces().size(); i++) {

                                    if (!rede.getGrupoDeInterfaces().getInterfaces().get(i).getEnderecoIpv4().isEmpty() && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesRecebidos() > 0 && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesEnviados() > 0) {

                                        redes.add(rede.getGrupoDeInterfaces().getInterfaces().get(i));

                                    }
                                }
                                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

                                System.out.println(String.format("%.2f %%", (api.getProcessadorEmUso())));
                                System.out.println(String.format("%.2f GB do Disco", (finalUsoDisco1)));
                                System.out.println(timeStamp);
                                System.out.println(String.format("%.2f GB da RAM", (finalUsoRam1)));
                            }
                        },
                                0, 60000);
            }

            hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());
            System.out.println(hostname.get(0).getIdMaquina());

        } else {
            System.out.println("""
                             Senha ou login invalido
                              ou usuario nao cadastrado via web""");
        }
    }
}
