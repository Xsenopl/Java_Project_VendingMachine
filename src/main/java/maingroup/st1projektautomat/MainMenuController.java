package maingroup.st1projektautomat;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import maingroup.st1projektautomat.backend.cAutomatController;

import java.io.IOException;

public class MainMenuController {
    @FXML private Label welcomeText;

    cAutomatController controller = StartApplication.controller1;

    @FXML
    private void switchToMain() throws IOException {
        StartApplication.setRoot("main");
        controller.test();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML void closeApp(){
        Platform.exit();
    }
}