package db.service.iService;

import db.dao.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    boolean insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int id);
}
