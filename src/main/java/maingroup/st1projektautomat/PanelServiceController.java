package maingroup.st1projektautomat;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import maingroup.st1projektautomat.backend.*;
import maingroup.st1projektautomat.backend.cAutomatController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PanelServiceController implements Initializable {

    private cAutomatController controller = StartApplication.controller1;
    private List<Produkt> localDBList = controller.getAutomatDB();
    @FXML private TableView<Produkt> tabOfProducts;
    @FXML private TableColumn<Object, Object> col_id;
    @FXML private TableColumn<Object, Object> col_nazwa;
    @FXML private TableColumn<Object, Object> col_nr;
    @FXML private TableColumn<Object, Object> col_cena;
    @FXML private TableColumn<Object, Object> col_ilosc;
    @FXML private Label lab1, lab2;



    Produkt p1 = new Produkt(0,10, "prod1", 1.20, 3);
    Produkt p2 = new Produkt(1,11, "prod2", 1.70, 5);
    Produkt p3 = new Produkt(2,12, "prod3", 10.0, 0);





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
   //     updateLocalList();

        col_id.setCellValueFactory(                new PropertyValueFactory<>("id"));
        col_nazwa.setCellValueFactory(                new PropertyValueFactory<>("nazwa"));
        col_nr.setCellValueFactory(                new PropertyValueFactory<>("nr_na_liscie"));
        col_cena.setCellValueFactory(                new PropertyValueFactory<>("cena"));
        col_ilosc.setCellValueFactory(                new PropertyValueFactory<>("ilosc"));

        ObservableList<Produkt> lista= FXCollections.observableArrayList();


        updateLocalList(lista);


     //   updateLocalList();

 //       lista.add(p1);
 //       lista.add(p2);
 //       lista.add(p3);

        tabOfProducts.getItems().addAll(lista);

        TableView.TableViewSelectionModel<Produkt> selectionModel = tabOfProducts.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);      //MULTIPLE pozwoli zaznaczać więcej
        ObservableList<Produkt> selectedItems =
                selectionModel.getSelectedItems();


        selectedItems.addListener(
                new ListChangeListener<Produkt>() {
                    @Override
                    public void onChanged( Change<? extends Produkt> change )
                    {
                        Produkt os=change.getList().get(0);
                    }
                });

    }
    @FXML public void akcja1(){}
    @FXML public void akcja2(){

    }
    @FXML public void akcja3(){

    }
    @FXML public void akcja4(){

    }
    @FXML public void showFromList(){
        Produkt p =  tabOfProducts.getSelectionModel().getSelectedItem();          // Niestety wszędzie gdzie nr powinien być null, to jest zero?
        if(p.getNr_na_liscie() == null)
            lab1.setText("Produkt: " + p.toString(false));
        lab1.setText("Produkt: "+ p.toString(true));
  //    lab1.setText( tabOfProducts.getSelectionModel().getSelectedItem().getNazwa());

    }
    private void updateLocalList(List<Produkt> listaa){
 //       localDBList.addAll(Arrays.asList(controller.getAutomatTab()));
        listaa.addAll(controller.getAutomatDB());
    }
    @FXML
    private void switchToAutomatPanel() throws IOException {
        StartApplication.setRoot("panel-automat");
    }

}
