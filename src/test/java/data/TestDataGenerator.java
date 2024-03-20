package data;

import db.dao.Employee;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.github.javafaker.Faker;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestDataGenerator {
    private static final Logger logger = LogManager.getLogger(TestDataGenerator.class);

    public Employee generateEmployee() {
        Faker faker = new Faker();
        Employee employee = new Employee();
        employee.setId(getRandomId());
        employee.setName(faker.name().firstName());
        employee.setAge(getRandomAge());
        employee.setAddress(faker.address().city());
        employee.setSalary(generateSalary());
        logger.info("Generated Employee data: " + employee);
        return employee;
    }

    private int getRandomId() {
        return new Random().nextInt(50);
    }

    private int getRandomAge() {
        int max = 60, min = 18;
        return new Random().nextInt(max - min + 1) + min;
    }

    private int generateSalary() {
        int min = 10, max = 60;
        int i = new Random().nextInt(max - min + 1) + min;
        return Integer.parseInt(i + "000");
    }
}
