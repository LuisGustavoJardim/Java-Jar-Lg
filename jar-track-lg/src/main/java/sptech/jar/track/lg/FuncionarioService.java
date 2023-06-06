package sptech.jar.track.lg;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FuncionarioService {
    public List<Funcionario> login (String email, String senha) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.query("select * from funcionario where email = ? and senha = ?", new BeanPropertyRowMapper(Funcionario.class), email, senha);
    }

    public Integer retornarFkEmpresa(String email, String senha) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("select fkEmpresa from funcionario where email = ? and senha = ?", Integer.class, email, senha);
    }
}
