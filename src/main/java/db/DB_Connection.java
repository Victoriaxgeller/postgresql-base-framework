package db;

import db.utils.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    protected static final Logger logger = LogManager.getLogger(DB_Connection.class);
    protected static Connection connection;
    protected static Connection connect() {
        if (connection != null) {
            return connection;
        }
        try {
            PropertyLoader prop = new PropertyLoader();
            connection = DriverManager
                    .getConnection(prop.getDb_url(),
                            prop.getUser(), prop.getPassword());
        } catch (Exception e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
        }
        logger.info("Opened database successfully");
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                logger.info("Closed database successfully");

            }
        } catch (SQLException e) {
            logger.error("SQLException error: " + e.getMessage());
        }
    }
}
