package maingroup.st1projektautomat.backend;

public class cAutomatController implements iAutomatControllerInterface{

    private cAutomat automat;
    public cAutomatController(cAutomat a){ automat = a; }

    @Override
    public boolean nrTest(int nr) {
        return (automat.checkNrMscNULL(nr) && automat.checkNrMscZero(nr));
    }

    @Override
    public boolean buyProduct(int nr) {
       return automat.buy(nr);
    }

    @Override
    public double getProductPrice(int nr) {
        return automat.priceOfProduct(nr);
    }
    public Produkt[] getAutomatTab(){
        return automat.getProdukty();
    }

}
