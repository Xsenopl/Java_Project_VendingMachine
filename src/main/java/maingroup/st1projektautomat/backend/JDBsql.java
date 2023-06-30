package maingroup.st1projektautomat.backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBsql implements iJDBsqlInterface {
    final protected String url = "jdbc:mysql://127.0.0.1/st1projekt";
    final protected String username = "root";
    final protected String password = "root";
    private Connection connection;

    public JDBsql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Połączono z bazą");

//            //Wyświetlenie dla potwierdzenia
//            Statement statement = connection.createStatement();
//            String s = "produkty";
//            ResultSet resultSet=statement.executeQuery("select * from "+s+" Inner join towary ON id=id_prod ORDER BY `produkty`.`id` ASC");
//
//            while(resultSet.next()){
//                wyswietlDane(resultSet);
//            }


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
    public void closeDB(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Wyj 4 (zamknięcie bazy): " + e);
        }
    }

    public void wyswietlDane(ResultSet rs) {
        try {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        } catch (SQLException e) {
            System.out.println("Wyj wyświetl: " + e + "\n");
            // e.printStackTrace();
        }
    }

    public Produkt[] fromDBtoTab(int l) {
        Produkt[] tabtemp = new Produkt[l];

        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id, nr_na_liscie, nazwa, cena, ilosc from produkty inner join towary On id=id_prod");
            while (rs.next()) {
                //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+sr.getDouble(3)+" "+sr.getInt(4));
                int nr = rs.getInt(2);
                if (nr < l)
                    tabtemp[nr] = new Produkt(rs.getInt(1), nr, rs.getString(3), rs.getDouble(4), rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("Wyj (przeniesienieZ): " + e);
        }
        closeDB(connection);
        return tabtemp;
    }

    public void buy1(Produkt towar) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement prepStmt = connection.prepareStatement("Update towary set ilosc = ? WHERE nr_na_liscie = ? ;");
            prepStmt.setInt(1, towar.getIlosc());
            prepStmt.setInt(2, towar.getNr_na_liscie());
            prepStmt.execute();
        } catch (SQLException e) {
            System.out.println("Wyj (przeniesienieDo): " + e);
        }
        closeDB(connection);
    }


    public List<Produkt> fromDbAllToList() {
        List<Produkt> listtemp = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id, nr_na_liscie, nazwa, cena, ilosc from produkty left join towary On id=id_prod Order By produkty.id");
            while (rs.next()) {
                //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+sr.getDouble(3)+" "+sr.getInt(4));

                    listtemp.add(new Produkt(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));
            }
        } catch (SQLException e) {
            System.out.println("Wyj (przeniesienieCałejDoListy): " + e);
        }
        closeDB(connection);
        return listtemp;
    }










}