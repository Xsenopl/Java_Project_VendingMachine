package maingroup.st1projektautomat.backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface iJDBsqlInterface {
    void closeDB(Connection con);
    void wyswietlDane(ResultSet rs);
    Produkt[] fromDBtoTab(int l);
    List<Produkt> fromDbAllToList();
    void buy1(Produkt towar);

    boolean deleteFromBase(int i);




}
