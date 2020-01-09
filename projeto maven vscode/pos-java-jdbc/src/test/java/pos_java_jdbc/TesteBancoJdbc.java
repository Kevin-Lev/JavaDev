package pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.UserPosJava;

public class TesteBancoJdbc {

    @Test
    public void initBanco() {
        // SingleConnection.getConnection();
    }

    @Test
    public void salvarUser() {
        UserPosDAO userPosDAO = new UserPosDAO();
        UserPosJava userPosJava = new UserPosJava();

        // userPosJava.setId(5L); // L na frente converte o número pra Long int;
        userPosJava.setNome("tiririca");
        userPosJava.setEmail("asjdsakmdaskmd");

        try {
            userPosDAO.salvar(userPosJava);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initListar() {
        UserPosDAO userDao = new UserPosDAO();
        try {
            List<UserPosJava> list = userDao.listarUsers();

            for (UserPosJava user: list) {
                System.out.println(user.toString());
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void initBuscar() {
        UserPosDAO userDao = new UserPosDAO();
        UserPosJava userPosJava = new UserPosJava();
        try {
            userPosJava = userDao.buscaUser(1L);
            System.out.println(userPosJava.toString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void initAtualizar() {
        UserPosDAO userDAO = new UserPosDAO();

        UserPosJava objetoBanco;
        try {
            objetoBanco = userDAO.buscaUser(4L);
            objetoBanco.setNome("Nome mudado com método atualizar");
            userDAO.atualizar(objetoBanco);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void initDeletar() {
        UserPosDAO userDao = new UserPosDAO();

        userDao.deletarUser(10L);
    }

    @Test
    public void testeInsertTelefone() {
        Telefone tel = new Telefone();
        UserPosDAO userDao = new UserPosDAO();

        tel.setNumero("44 99867-0945");
        tel.setTipo("Casa");
        tel.setIdUsuario(5L);

        userDao.salvarTelefone(tel);
    }

    @Test
    public void testeJoinUserFone() {
        UserPosJava userPos = new UserPosJava();
        UserPosDAO userDao = new UserPosDAO();
        List<BeanUserFone> listUserFones = userDao.listaUserFone(10L);

        for (BeanUserFone beanUserFone : listUserFones) {
            System.out.println(beanUserFone.toString());
        }
    }

    @Test
    public void testeDeleteUserFone() {
        UserPosDAO userDao = new UserPosDAO();

        userDao.deleteFonesPorUser(10L);
    }

}