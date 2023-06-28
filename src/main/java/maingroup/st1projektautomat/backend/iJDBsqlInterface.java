package maingroup.st1projektautomat.backend;

import java.sql.Connection;
import java.sql.ResultSet;

public interface iJDBsqlInterface {
    void closeDB(Connection con);
    void wyswietlDane(ResultSet rs);
    Produkt[] fromDBtoTab(int l);
    void buy1(Produkt towar);
}
