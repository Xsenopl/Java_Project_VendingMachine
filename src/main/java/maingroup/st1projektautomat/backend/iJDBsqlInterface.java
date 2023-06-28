package maingroup.st1projektautomat.backend;

import java.sql.Connection;

public interface iJDBsqlInterface {
    void closeDB(Connection con);
}
