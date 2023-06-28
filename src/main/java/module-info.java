module maingroup.st1projektautomat {
    requires javafx.controls;
    requires javafx.fxml;


    opens maingroup.st1projektautomat to javafx.fxml;
    exports maingroup.st1projektautomat;
}