package maingroup.st1projektautomat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class PanelAutomatController {

    @FXML private ToggleGroup numerPGroup;
    @FXML private Label moneyLabel, infoLabel;
    @FXML private RadioButton msc1;


    @FXML
    private void switchToMain() throws IOException {
        StartApplication.setRoot("main");
    }
    @FXML
    private void buyAction(){
        if(numerPGroup.getSelectedToggle()==msc1)
        infoLabel.setText("Kup: towar");
        else
            infoLabel.setText("Nie wybrano towaru");
    }
}
