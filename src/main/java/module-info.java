module maingroup.st1projektautomat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens maingroup.st1projektautomat to javafx.fxml;
    exports maingroup.st1projektautomat;
}