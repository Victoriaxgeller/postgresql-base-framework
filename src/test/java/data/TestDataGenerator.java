package data;

import lombok.extern.java.Log;
import org.apache.commons.lang3.RandomStringUtils;
import postgres.entity.EmployeeEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Log
public class TestDataGenerator {


    public EmployeeEntity generateTestEmployee() {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(getRandomId());
        employee.setName(generateRandomName());
        employee.setAge(getRandomAge());
        employee.setAddress(getRandomAddress());
        employee.setSalary(generateSalary());
        log.info("GENERATED TEST ENTITY: " + employee);
        return employee;
    }

    private int getRandomNameLength() {
        int max = 10, min = 5;
        return new Random().nextInt(max - min + 1) + min;
    }

    private int getRandomId() {
        return new Random().nextInt(1000);
    }

    private int getRandomAge() {
        int max = 60, min = 18;
        return new Random().nextInt(max - min + 1) + min;
    }

    private String generateRandomName() {
        String name = RandomStringUtils.random(getRandomNameLength(), true, false);
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    private String getRandomAddress() {
        List<String> list = Arrays.asList("Austin", "Boston", "Salem", "Oklahoma City", "Atlanta", "Columbia", "California", "Richmond", "Nashville", "Madison");
        return list.get(new Random().nextInt(list.size()));
    }

    private int generateSalary() {
        int min = 10, max = 60;
        int i = new Random().nextInt(max - min + 1) + min;
        return Integer.parseInt(i + "000");
    }
}
