package maingroup.st1projektautomat;

import javafx.fxml.FXML;

import java.io.IOException;

public class MainController {

    @FXML
    private void switchToMainMenu() throws IOException {
        StartApplication.setRoot("main-menu");
    }

}
