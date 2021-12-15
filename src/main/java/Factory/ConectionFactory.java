package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

    public static Connection getConection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/prova04", "root", "femina123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
