package org.example.DAO;

import org.example.domain.School;
import org.example.domain.RegisterSchool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Dao { //classe de interação com o banco
    private Connection conn;

    public Dao(Connection connection){
        this.conn = connection;
    }

    public void save(RegisterSchool registerSchool){
        var school = new School(registerSchool);

        String sql = "INSERT INTO escolas (codInep, localizacao, escola, endereco, logradouro, cep, diretor, secretario)"
                + "VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql); //prepara a consulta no BD

            //define os valores
            ps.setInt(1, school.getCodInep());
            ps.setString(2, school.getLocalizacao());
            ps.setString(3, school.getNomeEscola());
            ps.setString(4, school.getEndereco());
            ps.setString(5, school.getLogradouro());
            ps.setInt(6, school.getCep());
            ps.setString(7, school.getDiretorNome());
            ps.setString(8, school.getSecretarioNome());

            ps.execute(); //executa a instrução
            ps.close(); //fecha o ps
            conn.close(); //fecha a conexão

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Set<School> listar(){
        PreparedStatement ps;
        ResultSet rs;
        Set<School> school = new HashSet<>();

        String sql = "SELECT * FROM escolas";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Integer codInep = rs.getInt(1);
                String localizacao = rs.getNString(2);
                String nomeEscola = rs.getNString(3);
                String endereco = rs.getNString(4);
                String logradouro = rs.getNString(5);
                Integer cep = rs.getInt(6);
                String nomeDiretor = rs.getNString(7);
                String nomeSecretario = rs.getNString(8);

                RegisterSchool registerSchool = new RegisterSchool(
                        codInep, localizacao, nomeEscola, endereco, logradouro,
                        cep, nomeDiretor, nomeSecretario);

//                School school1 = new School(registerSchool);
                school.add(new School(registerSchool));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return school;
    }
    public void apagar(Integer codigo){
        PreparedStatement ps;
        String sql = "DELETE FROM escolas WHERE codInep = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ps.close();
            conn.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void alterar(int codigo, String campo, String valor){
        PreparedStatement ps;
        String sql = "UPDATE escolas SET " + campo + " = ? WHERE codInep = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, codigo);

            ps.executeUpdate();
            conn.commit();
            ps.close();
            conn.close();

        } catch (SQLException e){
            try {
                conn.rollback();
            } catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }


}
