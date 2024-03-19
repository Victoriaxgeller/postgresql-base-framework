package postgres.query;

import postgres.conn.DB_ConnectivityManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresDelete extends DB_ConnectivityManager {

    public void deleteData(String SQL) {
        try {
            setupDB();
            stmt = connection.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records deleted successfully");
    }
}