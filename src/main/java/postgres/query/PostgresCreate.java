package postgres.query;
import postgres.conn.DB_ConnectivityManager;

import java.sql.Connection;
import java.sql.Statement;

public class PostgresCreate {
    public static void main(String args[]) {
        Connection c = new DB_ConnectivityManager().connect();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}