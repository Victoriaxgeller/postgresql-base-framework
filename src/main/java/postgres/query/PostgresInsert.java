package postgres.query;

import postgres.conn.DB_ConnectivityManager;

import java.sql.SQLException;

public class PostgresInsert extends DB_ConnectivityManager {

    public void insertData(String SQL) {
        try {
            setupDB();
            stmt = connection.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }
}