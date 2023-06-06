/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.jar.track.lg;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
public class RedeService {
    public void cadastrarRede(Redes rede) {
        Conexao conexao = new Conexao();
        ConexaoMysql conexaoMysql = new ConexaoMysql();

        JdbcTemplate con = conexao.getConnection();
        JdbcTemplate conMysql = conexaoMysql.getConnection();

        con.update("insert into placaRede(nomeRede,nomeExibicao,ipv4,mac,fkMaquina) values (?, ?, ?, ?,?)", rede.getNomeRede(), rede.getNomeExibicao(), rede.getIpv4(), rede.getMac(),rede.getFkMaquina());
        conMysql.update("insert into placaRede(idRede,nomeRede,nomeExibicao,ipv4,mac,fkMaquina) values (?,?, ?, ?, ?,?)",retornarIdRede(rede), rede.getNomeRede(), rede.getNomeExibicao(), rede.getIpv4(), rede.getMac(),rede.getFkMaquina());
    }

    public Integer retornarIdRede (Redes rede) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("select idRede from placaRede where nomeRede = ? and nomeExibicao = ? and ipv4 = ? and mac = ?", Integer.class, rede.getNomeRede(), rede.getNomeExibicao(), rede.getIpv4(), rede.getMac());
    }
}
