package maingroup.st1projektautomat.backend;

public class cAutomat extends JDBsql{
    private double money;
    final private short large = 8, depth =10;
    final private String password = "qwe123";
    private Produkt[] produkty = new Produkt[large];

    public cAutomat() {
        this.money = 100;

        produkty = fromDBtoTab(large);
    }

    public boolean buy(int nr) {
        if(produkty[nr] == null) {
            System.out.println("Pusty numerek");
            return false;
        }
        System.out.println("Wybrano " + produkty[nr].getNr_na_liscie() + ". " + produkty[nr].getNazwa());
        System.out.println(produkty[nr].getIlosc());
        produkty[nr].setIlosc(produkty[nr].getIlosc()-1);
        System.out.println(produkty[nr].getIlosc());

        buy1(produkty[nr]);
        return true;
    }

    @Override
    public boolean deleteFromBase(int id){
        boolean result = super.deleteFromBase(id);

       if( result) {
           produkty = fromDBtoTab(large);
            return true;
       }
        return false;
    }


    public double priceOfProduct(int nr){
        return produkty[nr].getCena();
    }
    public Produkt[] getProdukty() { return produkty; }
    public String getPassword() { return password;  }
    public boolean checkNrMscNULL(int msc) throws ArrayIndexOutOfBoundsException{ return produkty[msc] != null;}            //Zwraca true, jeśli miejsce nie jest puste
    public boolean checkNrMscZero(int msc) throws ArrayIndexOutOfBoundsException{  return produkty[msc].getIlosc() != 0;}   //Zwraca true, jeśli miejsce posiada ilość != 0
}
