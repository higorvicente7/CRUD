package org.example.domain;

import org.example.DAO.Dao;

import java.sql.Connection;
import java.util.Set;

public class Service { //Classe de conexão com o banco
    private ConnectionFactory connection;

    public Service() { //Construtor obtém a conexão com o banco
        this.connection = new ConnectionFactory();
    }

    public void register(RegisterSchool registerSchool){ //registra uma nova escola
        Connection conn = connection.recoverConnection();
        new Dao(conn).save(registerSchool);
    }
    public Set<School> listSchool(){ //lista as escolas
        Connection conn = connection.recoverConnection();
        return new Dao(conn).listar();
    }
    public void apagar(Integer codigo){
        Connection conn = connection.recoverConnection();
        new Dao(conn).apagar(codigo);
    }
    public void alterar(int codigo, String campo, String valor){
        Connection conn = connection.recoverConnection();
        new Dao(conn).alterar(codigo, campo, valor);
    }
}
