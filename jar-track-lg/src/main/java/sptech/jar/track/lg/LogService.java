package sptech.jar.track.lg;

import org.springframework.jdbc.core.JdbcTemplate;

public class LogService {
    
      public Integer retornarIdLog (Log log) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("select idLog from log where horarioCapturado = ? and fkMaquina= ? and janelaPid = ? ", Integer.class, log.getHorarioCapturado(), log.getFkMaquina(), log.getJanelaPid());
      }
    public void salvarLog(Log log) {
        Conexao conexao = new Conexao();
        ConexaoMysql conexaoMysql = new ConexaoMysql();

        JdbcTemplate con = conexao.getConnection();
        JdbcTemplate conMysql = conexaoMysql.getConnection();

        //quaz
        con.update("insert into log(horarioCapturado,janelaPid,tituloJanela,usoCpu,usoDisco,usoRam,bytesRecebidos,bytesEnviados,fkMaquina) values (?, ?, ?, ?, ?,?,?,?,?)", log.getHorarioCapturado(), log.getJanelaPid(), log.getTituloJanela(), log.getUsoCpu(), log.getUsoDisco(), log.getUsoRam(),log.getBytesRecebidos(),log.getBytesEnviados(), log.getFkMaquina());

//        conMysql.update("insert into log(idLog,horarioCapturado,janelaPid,tituloJanela,usoCpu,usoDisco,usoRam,bytesRecebidos,bytesEnviados,fkMaquina) values (?,?, ?, ?, ?, ?,?,?,?,?)",retornarIdLog(log), log.getHorarioCapturado(), log.getJanelaPid(), log.getTituloJanela(), log.getUsoCpu(), log.getUsoDisco(), log.getUsoRam(),log.getBytesRecebidos(),log.getBytesEnviados(), log.getFkMaquina());
    }

    public void salvarLogMysql(Log log) {

        ConexaoMysql conexaoMysql = new ConexaoMysql();

        JdbcTemplate conMysql = conexaoMysql.getConnection();



        conMysql.update("insert into log(idLog,horarioCapturado,janelaPid,tituloJanela,usoCpu,usoDisco,usoRam,bytesRecebidos,bytesEnviados,fkMaquina) values (?,?, ?, ?, ?, ?,?,?,?,?)",retornarIdLog(log), log.getHorarioCapturado(), log.getJanelaPid(), log.getTituloJanela(), log.getUsoCpu(), log.getUsoDisco(), log.getUsoRam(),log.getBytesRecebidos(),log.getBytesEnviados(), log.getFkMaquina());
    }

  

}
