package postgres.query.entityQuery;

import lombok.extern.java.Log;
import postgres.entity.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Log
public class EmployeeQuery extends Query {

    public void insertNewEmployee(EmployeeEntity employee) {
        String SQL = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + format("VALUES ( %s,'%s', %s, '%s', %s );", employee.getId(), employee.getName(), employee.getAge(),
                employee.getAddress(), employee.getSalary());
        insert().insertData(SQL);

    }

    public EmployeeEntity selectEmployee(int id) {
        ResultSet set = select().selectData(format("SELECT * FROM COMPANY WHERE ID = %s", id));
        EmployeeEntity employee;
        try {
            employee = parseResultSet(set).get(0);
            System.out.println(employee);

        } catch (IndexOutOfBoundsException e) {
            return null;
        }

        return employee;
    }

    public List<EmployeeEntity> selectListOfAllEmployees() {
        ResultSet set = select().selectData("SELECT * FROM COMPANY;");
        return parseResultSet(set);
    }

    public void deleteEmployee(int id) {
        String SQL = format("DELETE from COMPANY where ID = %s;", id);
        delete().deleteData(SQL);
    }

    public void deleteAllEmployees() {
        List<EmployeeEntity> employees = selectListOfAllEmployees();
        employees.stream().map(EmployeeEntity::getId).forEach(this::deleteEmployee);
    }

    public void updateEmployee(EmployeeEntity employee) {
        String SQL = format("UPDATE COMPANY set SALARY = %s, NAME = '%s',AGE = %s,ADDRESS = '%s' where ID=%s;",
                employee.getSalary(), employee.getName(), employee.getAge(), employee.getAddress(), employee.getId());
        update().updateData(SQL);
    }

    private List<EmployeeEntity> parseResultSet(final ResultSet rs) {
        List<EmployeeEntity> employees = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                EmployeeEntity employee = new EmployeeEntity(id, name, age, address, salary);
                employees.add(employee);
                log.info("RESULT SET FROM DB: " + employee);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

        }
        return employees;
    }
}