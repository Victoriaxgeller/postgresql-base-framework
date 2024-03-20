package db;

import data.TestDataGenerator;
import db.dao.Employee;
import db.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest extends BaseTest{


    @Test
    public void newEmployeeIsAddedToDBWithCorrectData() {
        Employee expectedEmployee = generator.generateEmployee();

        if (!service.insertEmployee(expectedEmployee)) {
            Assertions.fail("Failed to insert new Employee");
        }
        Employee actualEmployee = service.getEmployeeById(expectedEmployee.getId());
        Assertions.assertEquals(actualEmployee, expectedEmployee);
    }

    @Test
    public void employeeHasBeenDeletedFromDB() {
        Employee expectedEmployee = generator.generateEmployee();
        if (!service.insertEmployee(expectedEmployee)) {
            Assertions.fail("Failed to insert new Employee");
        }
        if (!service.deleteEmployee(expectedEmployee.getId())) {
            Assertions.fail("Failed to delete Employee");
        }
        Assertions.assertNull(service.getEmployeeById(expectedEmployee.getId()));
    }

    @Test
    public void employeeHasBeenUpdated() {
        Employee createdEmployee = generator.generateEmployee();
        Employee updatedEmployee = generator.generateEmployee();
        updatedEmployee.setId(createdEmployee.getId());
        if (!service.insertEmployee(createdEmployee)) {
            Assertions.fail("Failed to insert new Employee");
        }

        if (!service.updateEmployee(updatedEmployee)) {
            Assertions.fail("Failed to update Employee");
        }
        Employee actualEmployee = service.getEmployeeById(createdEmployee.getId());
        Assertions.assertEquals(actualEmployee, updatedEmployee);

    }

    //TODO replace raw query in DB with API service
}
