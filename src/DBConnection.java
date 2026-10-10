import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String url;
    private static String user;
    private static String password;
    private static Connection connection;

    public static Connection openConnection(String pUser, String pPasswort) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //temp TODO: remove temp jdbc data
        url = "jdbc\\:h2\\:~/tierheim";
        user = "admin";
        password = "geheim";
        //temp end
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public static void executeSQL(String sql) {
        try {
            if(connection.isClosed()) {
                throw new SQLException("Connection is closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
