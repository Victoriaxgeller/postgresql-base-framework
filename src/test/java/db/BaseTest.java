package db;

import data.TestDataGenerator;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import postgres.query.entityQuery.EmployeeQuery;

import java.sql.SQLException;

import static postgres.conn.DB_ConnectivityManager.closeConnection;

public abstract class BaseTest {
    protected TestDataGenerator testData = new TestDataGenerator();
    protected static EmployeeQuery query;


    @BeforeAll
    public static void setup() {
        query = new EmployeeQuery();
        query.deleteAllEmployees();
    }

    @AfterAll
    public static void close() throws SQLException {
        closeConnection();
    }
}