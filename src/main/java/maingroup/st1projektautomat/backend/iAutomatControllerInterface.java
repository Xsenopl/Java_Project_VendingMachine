package maingroup.st1projektautomat.backend;

public interface iAutomatControllerInterface {


    boolean buyProduct(int nr);
    double getProductPrice(int nr);
    Produkt[] getAutomatTab();

    boolean nrTest(int nr);
}
