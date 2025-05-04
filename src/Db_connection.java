import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_connection {
    private static final String Host = "127.0.0.1";
    private static final int Port = 3306;
    private static final String DB_name = "restaurant";
    private static final String Username = "root";
    private static final String Password = "";

    private static Connection connection;

    public static Connection getConnection() {
        try {

            String url = String.format("jdbc:mysql://%s:%d/%s", Host, Port, DB_name);
            connection = DriverManager.getConnection(url, Username, Password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }
}