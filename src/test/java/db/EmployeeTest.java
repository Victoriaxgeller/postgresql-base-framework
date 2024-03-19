package db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import postgres.entity.EmployeeEntity;

public class EmployeeTest extends BaseTest {

    @Test
    public void newEmployeeIsAddedToDBWithCorrectData() {
        EmployeeEntity expectedEmployee = testData.generateTestEmployee();
        query.insertNewEmployee(expectedEmployee);
        EmployeeEntity actualEmployee = query.selectEmployee(expectedEmployee.getId());
        Assertions.assertEquals(actualEmployee, expectedEmployee);
    }

    @Test
    public void employeeHasBeenDeletedFromDB() {
        EmployeeEntity expectedEmployee = testData.generateTestEmployee();
        query.insertNewEmployee(expectedEmployee);
        query.deleteEmployee(expectedEmployee.getId());
        Assertions.assertNull(query.selectEmployee(expectedEmployee.getId()));
    }

    @Test
    public void employeeHasBeenUpdated() {
        EmployeeEntity createdUser = testData.generateTestEmployee();
        EmployeeEntity updatedUser = testData.generateTestEmployee();
        updatedUser.setId(createdUser.getId());

        query.insertNewEmployee(createdUser);
        query.updateEmployee(updatedUser);
        EmployeeEntity actualEmployee = query.selectEmployee(createdUser.getId());
        Assertions.assertEquals(actualEmployee, updatedUser);

    }
    //TODO create new user -> temporary raw query in DB -> replace with API service

}
