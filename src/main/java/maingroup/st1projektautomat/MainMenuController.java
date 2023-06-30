package maingroup.st1projektautomat;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import maingroup.st1projektautomat.backend.cAutomatController;

import java.io.IOException;

public class MainMenuController {
    @FXML private Label welcomeText;

    @FXML
    private void switchToMain() throws IOException {
        StartApplication.setRoot("main");
    }

    @FXML void closeApp(){ Platform.exit(); }
}