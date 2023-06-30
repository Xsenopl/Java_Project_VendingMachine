package maingroup.st1projektautomat;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import maingroup.st1projektautomat.backend.Produkt;
import maingroup.st1projektautomat.backend.cAutomatController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class PanelAutomatController implements Initializable {

    cAutomatController controller = StartApplication.controller1;
    private List<Produkt> localList = new ArrayList();
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
        final int[] i = {0};
        updateLocalList();
        numerPGroup.getToggles().forEach( toggle -> {
            RadioButton radioButton = (RadioButton) toggle;
            updateRadioButtonText(radioButton, i[0]);
            i[0] = i[0] +1;
        });

        numerPGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
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
            informLabel(infoLabel, "W tym miejscu nie ma towaru.", 5000);
            numerPGroup.selectToggle(null);
            return;
        } catch (NumberFormatException e) {
            System.out.println("Nie można było przekonwertować zapłaty na double" + e);
            informLabel(infoLabel, "Musisz użyć gotówki do zapłaty", 5000);
            numerPGroup.selectToggle(null);
            return;
        }
        if (money < controller.getProductPrice(choose)) {
      //      moneyLabel.setText("--");
            informLabel(infoLabel, "Kwota niewystarczająca", 5000);
            numerPGroup.selectToggle(null);
            return;
        }

        if (controller.buyProduct(choose)) {
            infoLabel.setText("Zakupiłeś towar!");
        } else System.out.println("Coś poszło nie tak i nie kupiłeś towaru.");


        updateRadioButtonText((RadioButton) numerPGroup.getSelectedToggle(), choose);
        numerPGroup.selectToggle(null);
        payment.setText("");
    }

    @FXML
    private void showPassPrompt() throws RuntimeException{
  //      PasswordField passwordField = new PasswordField();  // Ukywa znaki
        TextInputDialog dialog = new TextInputDialog();


        dialog.setTitle("Podaj hasło");
        dialog.setHeaderText("Wpisz hasło:");
        dialog.setContentText("Hasło:");

        dialog.showAndWait().ifPresent(password -> {

            if(controller.logIn(password)){
                System.out.println("Poprawne hasło");
                try {
                    StartApplication.setRoot("panel-service");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                System.out.println("Błędne hasło. Porpawne to qwe123");
            }
        });


    }
    private void informLabel(Label label, String text, int time) {
        label.setText(text);
        // Tworzy nowy wątek
        new Thread(() -> {
            try {
                sleep(time); // Czekaj 5 sekund
                Platform.runLater(() -> label.setText("Informacje o sytuacji")); // Zmiana tekstu w wątku JavaFX
            } catch (InterruptedException e) {
                System.out.println("Błąd w nowym wątku"+ e); //e.printStackTrace()
            }
        }).start();
    }
    private boolean updateRadioButtonText(RadioButton radioButton, int i){
        try{
            if (localList.get(i) == null) {
                radioButton.setText(i + ".\nPuste");
            } else {
                radioButton.setText(localList.get(i).getNr_na_liscie() + ". \n" + localList.get(i).getNazwa() + " " + localList.get(i).getCena() + "zł \n[" + localList.get(i).getIlosc() + "]");
            }
        }catch (Exception e){
            System.out.println("Nie udało się zmienić wartości RadioButtona"); return false;
        }
        return true;
    }
    private void updateLocalList(){
        localList.addAll(Arrays.asList(controller.getAutomatTab()));
    }
    @FXML void closeApp(){ Platform.exit(); }
}





/*
        //W kontekście wyboru RadioButtona pozostało dla szybkiego dostępu
        if(numerPGroup.getSelectedToggle() ==msc1)
        infoLabel.setText("Kup: towar");
        else
            infoLabel.setText("Nie wybrano towaru");
 */
