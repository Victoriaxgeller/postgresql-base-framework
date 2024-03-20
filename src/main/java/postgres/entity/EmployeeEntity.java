package postgres.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    private int id;
    private String name;
    private int age;
    private String address;
    private float salary;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmployeeEntity) || this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;
        EmployeeEntity employee = (EmployeeEntity) o;
        return id == employee.id && age == employee.age && Float.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, address, salary);
    }
}
