package postgres.query;

import postgres.conn.ConnectionFactory;
import postgres.entity.EmployeeEntity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresInsert extends ConnectionFactory {

    public void insertData(String SQL) {
        try {
            connect();
            stmt = connection.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        logger.info("Records created successfully");
    }

    public void insertData(String SQL, EmployeeEntity employee) {
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setFloat(5, employee.getSalary());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        logger.info("Records created successfully");
    }
}