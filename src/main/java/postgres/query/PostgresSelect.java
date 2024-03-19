package postgres.query;

import postgres.conn.DB_ConnectivityManager;

import java.sql.SQLException;
import java.sql.ResultSet;

public class PostgresSelect extends DB_ConnectivityManager {
    public ResultSet selectData(String SQL) {
        try {
            ResultSet rs;
            setupDB();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(SQL);
            return rs;

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
        return null;
    }
}