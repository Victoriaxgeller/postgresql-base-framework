package postgres.query;

import postgres.conn.ConnectionFactory;

import java.sql.SQLException;
import java.sql.ResultSet;

public class PostgresSelect extends ConnectionFactory {
    public ResultSet selectData(String SQL) {
        try {
            ResultSet rs;
            connect();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(SQL);
            return rs;

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        logger.info("Records created successfully");
        return null;
    }
}