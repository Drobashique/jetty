package dbCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection connection = null;

    public static Connection connect(){
        final String URL = "jdbc:postgresql://localhost:5432/tech_db";
        final String username = "postgres";
        final String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("No connection with base: " + e);
        }
        return connection;
    }

    public static Connection getConnection() {
        return connection;
    }
}