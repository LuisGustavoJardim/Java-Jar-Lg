/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.jar.track.lg;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author hidek
 */
public class Conexao {
    
    private JdbcTemplate connection;

    public Conexao() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        dataSource.setUrl("jdbc:sqlserver://servidor-tracking-vision.database.windows.net:1433;database=bd-tracking-vision;user=admin-tracking-vision@servidor-tracking-vision;password=#Gfgrupo5;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");

        dataSource.setUsername("admin-tracking-vision");

        dataSource.setPassword("#Gfgrupo5");

//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/track");
//        dataSource.setUsername("root");
//        dataSource.setPassword("paulo1421");

        this.connection = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
}
