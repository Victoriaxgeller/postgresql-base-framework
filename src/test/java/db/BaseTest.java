package db;

import data.TestDataGenerator;
import db.service.EmployeeService;
import db.utils.HelperService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static db.DB_Connection.closeConnection;

public abstract class BaseTest {
    TestDataGenerator generator = new TestDataGenerator();
    EmployeeService service = new EmployeeService();

    @BeforeAll
    public static void prepare() {
        new HelperService().truncateTable();
    }

    @AfterAll
    public static void close() {
        closeConnection();
    }
}
