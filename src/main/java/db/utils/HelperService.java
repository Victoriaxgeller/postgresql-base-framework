package db.utils;

import db.DB_Connection;

import java.sql.Statement;

public class HelperService extends DB_Connection {

    public void createTable() {
        connect();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        TEXT, " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
        }
        logger.info("Table created successfully");
    }

    public void truncateTable() {
        connect();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "TRUNCATE company";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
        }
        logger.info("Table truncated successfully");
    }
}