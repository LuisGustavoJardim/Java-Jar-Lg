package sptech.jar.track.lg;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MaquinaService {
    public void salvarMaquina (Maquina maquina) {
        Conexao conexao = new Conexao();
        ConexaoMysql conexaoMysql = new ConexaoMysql();

        JdbcTemplate con = conexao.getConnection();
        JdbcTemplate conMysql = conexaoMysql.getConnection();

        con.update("insert into maquina(statusMaquina,hostnameMaquina,nomeModeloCpu,clockCpu,nomeModeloRam,capacidadeTotalRam,nomeModeloDisco,capacidadeTotalDisco,leituraDisco,escritaDisco,fkEmpresa) values (?,?,?,?,?,?,?,?,?,?,?)", 1,maquina.getHostnameMaquina(), maquina.getNomeModeloCpu(), maquina.getClockCpu(), maquina.getNomeModeloRam(), maquina.getCapacidadeTotalRam(), maquina.getNomeModeloDisco(), maquina.getCapacidadeTotalDisco(), maquina.getLeituraDisco(), maquina.getEscritaDisco(),null);
        conMysql.update("insert into maquina(idMaquina,status,hostnameMaquina,nomeModeloCpu,clockCpu,nomeModeloRam,capacidadeTotalRam,nomeModeloDisco,capacidadeTotalDisco,leituraDisco,escritaDisco,fkEmpresa,fkJanelasBloqueadas) values (?,?,?,?,?,?,?,?,?,?,?,?,?)",idMaquinaAtual(maquina.getHostnameMaquina()), 1,maquina.getHostnameMaquina(), maquina.getNomeModeloCpu(), maquina.getClockCpu(), maquina.getNomeModeloRam(), maquina.getCapacidadeTotalRam(), maquina.getNomeModeloDisco(), maquina.getCapacidadeTotalDisco(), maquina.getLeituraDisco(), maquina.getEscritaDisco(),null,null);
    }

    public List<Maquina> buscarPeloHostname(String hostname) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.query("select * from maquina where hostnameMaquina = ?", new BeanPropertyRowMapper(Maquina.class), hostname);
    }

    public Integer idMaquinaAtual(String hostname) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("select idMaquina from maquina where hostnameMaquina = ?", Integer.class, hostname);
    }


}
