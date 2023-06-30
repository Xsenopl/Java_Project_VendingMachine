package maingroup.st1projektautomat.backend;

import java.util.List;
import java.util.Objects;

public class cAutomatController implements iAutomatControllerInterface{

    private cAutomat automat;
    public cAutomatController(cAutomat a){ automat = a; }

    @Override
    public boolean nrTest(int nr) {
        return (automat.checkNrMscNULL(nr) && automat.checkNrMscZero(nr));
    }

    @Override
    public boolean logIn(String writePass) {
        return Objects.equals(writePass, automat.getPassword());
    }

    @Override
    public boolean buyProduct(int nr) {
       return automat.buy(nr);
    }

    @Override
    public double getProductPrice(int nr) {
        return automat.priceOfProduct(nr);
    }
    @Override
    public Produkt[] getAutomatTab(){
        return automat.getProdukty();
    }
    public List<Produkt> getAutomatDB(){
        return automat.fromDbAllToList();
    }

}
