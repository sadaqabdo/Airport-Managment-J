package airportmanagment;

import java.sql.*;

public class DBConnection {

    private static final String HOST = "localhost";
    private static final int PORT = 1521;
    private static final String DB_NAME = "airport_management_db";
    private static final String USERNAME = "system";
    private static final String PASSWORD = "admin";

    private static Connection connection;
    Statement stm;
    ResultSet rst;

    public static Connection getConnection() {
        // "jdbc:oracle:thin:@localhost:1521:XE"
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@" + HOST + ":" + PORT + ":XE", USERNAME, PASSWORD);
        } catch (SQLException se) {
            System.out.println("Connexion failed:" + se);
        }
        return connection;
    }

}
