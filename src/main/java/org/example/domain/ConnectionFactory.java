package org.example.domain;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory { //classe de conexão com o banco
    public Connection recoverConnection(){   //Método recupera uma conexão
        try {
            return createDataSource().getConnection();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    private HikariDataSource createDataSource(){  //Método que cria  e configura o objeto
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/relacao_escolas");
        config.setUsername("root");
        config.setPassword("Konoha77.");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
