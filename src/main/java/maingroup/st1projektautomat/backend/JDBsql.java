package maingroup.st1projektautomat.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBsql implements iJDBsqlInterface {
    final protected String url = "jdbc:mysql://127.0.0.1/dojavytest1";
    final protected String username = "root";
    final protected String password = "root";
    private Connection connection;

    public JDBsql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Połączono z bazą");

        } catch (ClassNotFoundException e) {
            //Wyrzuć wyjątki jeśli zostaną wychwycone błędy związane z podłączeniem z bazą lub błędy zapytania o dane
            System.out.println("Wyj 1: (Brak sterownika JDBC) " + e);
        } catch (SQLException e) {
            //Wyrzuć wyjątki jeśli zostaną wychwycone błędy związane z logowaniem do bazy i kwerendą
            System.out.println("Wyj 2: " + e);
        }
        assert connection != null;
        closeDB(connection);
    }
    @Override
    public void closeDB(Connection con){
        try {
            con.close();
        }catch(SQLException e) {
            System.out.println("Wyj 4 (zamknięcie bazy): " + e);
        }
    }




}
