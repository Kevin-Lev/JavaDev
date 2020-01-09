package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

    private static String url = "jdbc:postgresql://localhost:5432/posjava";
    private static String password = "admin";
    private static String user = "postgres";
    private static Connection connection = null;

    static {
        conectar();    
    }

    private SingleConnection() {
        conectar();
    }

    private static void conectar() {
        try {
            if (connection == null){
                //fazer a conexão.Conexão é feita uma vez só. Sessões podem ser abertas ou fechadas mais de uma vez
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false); // para não salvar automaticamente operações como insert no banco
                System.out.println("Conectou com sucesso!!!");
            }   
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}