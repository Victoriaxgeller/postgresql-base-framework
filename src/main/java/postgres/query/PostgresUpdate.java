package postgres.query;

import postgres.conn.ConnectionFactory;

import java.sql.SQLException;

public class PostgresUpdate extends ConnectionFactory {
    public void updateData(String SQL) {
            try {
                connect();
                stmt = connection.createStatement();
                stmt.executeUpdate(SQL);
                stmt.close();
                connection.commit();
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
            logger.info("Records updated successfully");
        }
}