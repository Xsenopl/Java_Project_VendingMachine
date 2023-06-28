package maingroup.st1projektautomat;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import maingroup.st1projektautomat.backend.Produkt;
import maingroup.st1projektautomat.backend.cAutomatController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PanelAutomatController implements Initializable {

    cAutomatController controller = StartApplication.controller1;
    private int choose;
    @FXML private TextField payment;
    @FXML private ToggleGroup numerPGroup;
    @FXML private Label moneyLabel, infoLabel;
    @FXML private RadioButton msc1;
    @FXML private RadioButton msc2;
    @FXML private RadioButton msc3;
    @FXML private RadioButton msc4;
    @FXML private RadioButton msc5;
    @FXML private RadioButton msc6;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numerPGroup.getToggles().forEach(toggle -> {
            RadioButton radioButton = (RadioButton) toggle;
            radioButton.setText("Towar");
        });
        numerPGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                selectedRadioButton.setText("Numer " + numerPGroup.getToggles().indexOf(selectedRadioButton));
                choose = numerPGroup.getToggles().indexOf(selectedRadioButton);
            }
        });

    }


    @FXML
    private void switchToMain() throws IOException {
        StartApplication.setRoot("main");
    }
    @FXML
    private void buyAction() {
        double money;

        try {
            if (!controller.nrTest(choose)) throw new ArrayIndexOutOfBoundsException();
            money = Double.parseDouble(payment.getText());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("puste lub brak");
            numerPGroup.selectToggle(null);
            return;
        } catch (NumberFormatException e) {
            System.out.println("Nie można było przekonwertować zapłaty na double" + e);
            numerPGroup.selectToggle(null);
            return;
        }
        if (money < controller.getProductPrice(choose)) {
            moneyLabel.setText("brakło Ci pieniędzy");
            numerPGroup.selectToggle(null);
            return;
        }

        if (controller.buyProduct(choose)) {
            infoLabel.setText("Zakupiłeś towar!");
        } else System.out.println("Coś poszło nie tak i nie kupiłes towaru.");

        numerPGroup.selectToggle(null);
        payment.setText("");
    }


    private void selectProduct(Produkt produkt) {
        System.out.println("Wybrano produkt: " + produkt.getNazwa());
    }
}





/*
        //W kontekście wyboru RadioButtona
        if(numerPGroup.getSelectedToggle() ==msc1)
        infoLabel.setText("Kup: towar");
        else
            infoLabel.setText("Nie wybrano towaru");
 */
