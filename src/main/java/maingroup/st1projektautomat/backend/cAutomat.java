package maingroup.st1projektautomat.backend;

public class cAutomat extends JDBsql{
    private double money;
    final private short large = 16, depth =10;
    final private String password = "qwe123";
    private Produkt[] produkty = new Produkt[large];

    public cAutomat() {
        super();
        this.money = 100;

        produkty = fromDBtoTab(large);
        System.out.println(produkty[6].toString());
    }

    public void test() {
        System.out.println("A udało się");
    }



}
