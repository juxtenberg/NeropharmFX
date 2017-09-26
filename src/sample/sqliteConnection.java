package sample;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Justin on 2/1/2017.
 */
public class sqliteConnection {

    public static Connection Connector() {
        try {
   Class.forName("org.sqlite.JDBC");
   Connection conn = DriverManager.getConnection("jdbc:sqlite:logindb.sqlite");
      return conn;

        } catch (Exception e){
            System.out.println(e);
      return null;

        }

    }

}
