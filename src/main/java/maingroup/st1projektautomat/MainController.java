package maingroup.st1projektautomat;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MainController {

    @FXML private ImageView automat1;
    @FXML
    private void switchToMainMenu() throws IOException {
        StartApplication.setRoot("main-menu");
    }
    @FXML
    private void switchToMainPanelAutomat() throws IOException {
        StartApplication.setRoot("panel-automat");
    }
    @FXML void closeApp(){ Platform.exit(); }

}
