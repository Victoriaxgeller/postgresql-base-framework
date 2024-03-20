package postgres.query;

import postgres.conn.ConnectionFactory;

import java.sql.SQLException;

public class PostgresDelete extends ConnectionFactory {

    public void deleteData(String SQL) {
        try {
            connect();
            stmt = connection.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
        }
        logger.info("Records deleted successfully");
    }
}