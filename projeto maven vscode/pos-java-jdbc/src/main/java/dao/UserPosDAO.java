package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
import model.UserPosJava;

public class UserPosDAO {

    private Connection connection;

    public UserPosDAO() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(UserPosJava userPosJava) {
        String sql = "insert into userposjava (nome, email) values (?, ?)";

        try {
            PreparedStatement insertUser = connection.prepareStatement(sql); // PreparedStatement vai fazer o insert
            // insertUser.setLong(1, userPosJava.getId()); // Argumento 1 (id) recebe o valor 3.
            insertUser.setString(1, userPosJava.getNome());
            insertUser.setString(2, userPosJava.getEmail());
            insertUser.execute(); // executar no banco
            connection.commit(); //Salva no banco
            System.out.println("Usuário " + userPosJava.getNome() + " salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarTelefone(Telefone tel) {

        try {
            String sql = "insert into telefoneuser(numero, tipo, usuariopessoa) VALUES (?, ?, ?);";
            PreparedStatement insertTelefone = connection.prepareStatement(sql);
            insertTelefone.setString(1, tel.getNumero());
            insertTelefone.setString(2, tel.getTipo());
            insertTelefone.setLong(3, tel.getIdUsuario());
            insertTelefone.execute();
            connection.commit();    
        }
        catch (Exception e) {
            e.printStackTrace();
            try{
                connection.rollback();
            }
            catch(SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
    
    public List<UserPosJava> listarUsers() throws SQLException {
        List<UserPosJava> list = new ArrayList<UserPosJava>();
        String sql = "select * from userposjava";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultado = statement.executeQuery();

        while (resultado.next()) { // enquanto tiver usuários para serem processados
            UserPosJava userPosJava = new UserPosJava();
            userPosJava.setId(resultado.getLong("id"));
            userPosJava.setNome(resultado.getString("nome"));
            userPosJava.setEmail(resultado.getString("email"));
            list.add(userPosJava);
        }

        return list;
    }

    public UserPosJava buscaUser(Long id) throws SQLException {
        UserPosJava userRetorno = new UserPosJava();
        String sql = "select * from userposjava where id = " + id;
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultado = statement.executeQuery();

        while (resultado.next()) { // enquanto tiver usuários para serem processados
            UserPosJava userPosJava = new UserPosJava();
            userPosJava.setId(resultado.getLong("id"));
            userPosJava.setNome(resultado.getString("nome"));
            userPosJava.setEmail(resultado.getString("email"));
            userRetorno = userPosJava;
        }
        return userRetorno;
    }

    public void atualizar (UserPosJava userPosJava){
        String sql = "update userposjava set nome = ? where id = " + userPosJava.getId();

        PreparedStatement atualizaUser;
        try {
            atualizaUser = connection.prepareStatement(sql);
            atualizaUser.setString(1, userPosJava.getNome());
            atualizaUser.execute();
            connection.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deletarUser(Long id) {
        String sql = "delete from userposjava where id = " + id;
        try {
            PreparedStatement deletaUser = connection.prepareStatement(sql);
            deletaUser.execute();
            connection.commit();
            System.out.println("Usuário deletado com sucesso!");
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void deleteFonesPorUser(Long idUser) {
        String sqlFone = "delete from telefoneuser where usuariopessoa = " + idUser;
        String sqlUser = "delete from userposjava where id = " + idUser;

        try {
            PreparedStatement statementFone = connection.prepareStatement(sqlFone);
            statementFone.executeUpdate();
            connection.commit();

            PreparedStatement statementUser = connection.prepareStatement(sqlUser);
            statementUser.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            System.out.println("Caiu no erro!!!");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public List<BeanUserFone> listaUserFone(Long idUser) {

        List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();

        String sql = "select numero,nome, email from telefoneuser as fone ";
        sql += "inner join userposjava as userp "; 
        sql += "on fone.usuariopessoa = userp.id "; 
        sql += "where userp.id = " + idUser;

        try {
            PreparedStatement listaUserFone = connection.prepareStatement(sql);
            ResultSet resultado = listaUserFone.executeQuery();

            while (resultado.next()) {
                BeanUserFone userFone = new BeanUserFone();
                userFone.setNome(resultado.getString("nome"));
                userFone.setEmail(resultado.getString("email"));
                userFone.setNumero(resultado.getString("numero"));
                beanUserFones.add(userFone);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return beanUserFones;
    }

}