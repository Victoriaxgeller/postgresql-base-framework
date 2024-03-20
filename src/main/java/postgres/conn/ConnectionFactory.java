package postgres.conn;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import postgres.utils.PropertyLoader;

import java.sql.*;


public class ConnectionFactory {
    protected static final Logger logger = LogManager.getLogger(ConnectionFactory.class);
    protected static Connection connection;
    protected static Statement stmt;
    protected PreparedStatement preparedStatement;

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
