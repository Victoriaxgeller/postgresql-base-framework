package db.service;

import db.DB_Connection;
import db.dao.Employee;
import db.service.iService.EmployeeServiceInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends DB_Connection implements EmployeeServiceInterface {

    public EmployeeService() {
        connect();
    }

    @Override
    public Employee getEmployeeById(int id) {
        String SQL = "SELECT * FROM COMPANY WHERE ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return extractEmployeeFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        String SQL = "SELECT * FROM COMPANY";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            return extractListFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        try {
            String SQL = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setFloat(5, employee.getSalary());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try {
            String SQL = "UPDATE COMPANY set SALARY =?, NAME = ?,AGE = ?,ADDRESS = ? where ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setFloat(1, employee.getSalary());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setInt(5, employee.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int id) {
        String SQL = "DELETE from COMPANY where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    private Employee extractEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return extractEmployee(resultSet);
        }
        return null;
    }

    private List<Employee> extractListFromResultSet(ResultSet rs) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try {
            while (rs.next()) {
                employees.add(extractEmployee(rs));
            }
        } catch (SQLException e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
        }
        return employees;
    }

    private Employee extractEmployee(ResultSet resultSet) {
        try {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setAge(resultSet.getInt("age"));
            employee.setAddress(resultSet.getString("address"));
            employee.setSalary(resultSet.getFloat("salary"));
            return employee;
        } catch (SQLException e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
