package postgres.query;

import postgres.conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.Statement;

public class PostgresCreate extends ConnectionFactory {

    public void createTable() {
        Connection c = new ConnectionFactory().connect();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        TEXT, " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        logger.info("Table created successfully");
    }
}