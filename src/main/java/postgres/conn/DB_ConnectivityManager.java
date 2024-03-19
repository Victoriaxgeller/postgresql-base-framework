package postgres.conn;

import lombok.extern.java.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Log
public class DB_ConnectivityManager {
    protected static Connection connection;
    protected static Statement stmt = null;


    //TODO singleton

    protected static Connection connect() {
        if (connection != null) {
            return connection;
        }
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/testdb",
                            "postgres", "admin");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return connection;
    }

    public void setupDB() throws SQLException {
        connect();
        connection.setAutoCommit(false);

    }

    public static void closeConnection() throws SQLException {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Closed database successfully");

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
