package maingroup.st1projektautomat.backend;

public class Produkt {
    private Integer id;
    private Integer nr_na_liscie;
    private String nazwa;
    private double cena;
    private int ilosc;

    public Produkt(Integer id, Integer nr_na_liscie, String nazwa, double cena, int ilosc) throws NullPointerException{
        this.id = id;
        this.nr_na_liscie = nr_na_liscie;
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    public Integer getId()              { return id; }
    public Integer getNr_na_liscie()    { return nr_na_liscie; }
    public String getNazwa()            { return nazwa; }
    public double getCena()             { return cena; }
    public int getIlosc()               { return ilosc; }

    public void setId(Integer id)       { this.id = id; }
    public void setNr_na_liscie(Integer nr_na_liscie) { this.nr_na_liscie = nr_na_liscie; }
    public void setNazwa(String nazwa)  {  this.nazwa = nazwa; }
    public void setCena(double cena)    { this.cena = cena; }
    public void setIlosc(int ilosc)     { this.ilosc = ilosc; }

}
