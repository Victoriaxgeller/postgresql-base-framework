package postgres.query;

import postgres.conn.DB_ConnectivityManager;

import java.sql.SQLException;

public class PostgresUpdate extends DB_ConnectivityManager {
    public void updateData(String SQL) {
            try {
                setupDB();
                stmt = connection.createStatement();
                stmt.executeUpdate(SQL);
                stmt.close();
                connection.commit();
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
            System.out.println("Records updated successfully");
        }
}