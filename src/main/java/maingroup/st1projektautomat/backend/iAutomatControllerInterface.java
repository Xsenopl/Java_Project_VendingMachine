package maingroup.st1projektautomat.backend;

import java.util.List;

public interface iAutomatControllerInterface {


    boolean buyProduct(int nr);
    double getProductPrice(int nr);
    Produkt[] getAutomatTab();
    List<Produkt> getAutomatDB();

    boolean nrTest(int nr);
    boolean logIn(String writePass);
}
