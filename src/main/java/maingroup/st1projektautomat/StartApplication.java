package maingroup.st1projektautomat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import maingroup.st1projektautomat.backend.cAutomat;
import maingroup.st1projektautomat.backend.cAutomatController;

import java.io.IOException;
import java.sql.*;

public class StartApplication extends Application {
    private static Connection connection;
    private static Statement statement;
    private static Scene scene;
    private static final cAutomat automat1 = new cAutomat();
    public static cAutomatController controller1 = new cAutomatController(automat1);
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("main-menu.fxml"));
        scene = new Scene(loadFXML("main-menu"),700, 500);
        stage.setTitle("Automat");
        stage.setScene(scene);
        stage.show();




    }

    public static void main(String[] args) {

/*
        String url="jdbc:mysql://127.0.0.1/dojavytest1";
        String username="root";
        String password="root";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);

            statement = connection.createStatement();
            //zmienDane();
            //   usunDane();
            String s = "student";
            ResultSet resultSet=statement.executeQuery("select * from "+s);


            while(resultSet.next()){
                wyswietlDane(resultSet);
            }
//            dodajDane();

            connection.close();
        }catch (ClassNotFoundException e){
            //Wyrzuć wyjątki jeśli zostaną wychwycone błędy związane z podłączeniem z bazą lub błędy zapytania o dane
            System.out.println("Wyj 1: (Brak sterownika JDBC) "+e);
        }catch(SQLException e){
            //Wyrzuć wyjątki jeśli zostaną wychwycone błędy związane z logowaniem do bazy i kwerendą
            System.out.println("Wyj 2: "+e);
        }
*/

        launch();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }





    public static void wyswietlDane(ResultSet rs){
        try{
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
        }catch(SQLException e){
            System.out.println("Wyj wyświetl: "+e +"\n");
            // e.printStackTrace();
        }
    }


}