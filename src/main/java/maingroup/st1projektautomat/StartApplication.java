package maingroup.st1projektautomat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import maingroup.st1projektautomat.backend.cAutomat;
import maingroup.st1projektautomat.backend.cAutomatController;

import java.io.IOException;
import java.sql.*;

/**
 * @author Bogusław Szura
 */

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

    public static void main(String[] args) { launch(); }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}