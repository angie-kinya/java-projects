package LibraryDatabase;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library_db";
        String user = "root";
        String password = "Beomgyu@0313";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect!");
            e.printStackTrace();
        }
    }
}
