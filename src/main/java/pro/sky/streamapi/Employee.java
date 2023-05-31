package pro.sky.streamapi;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final int salary;
    private final int department;
    private final int age;

    public Employee(String firstName, String lastName, String middleName, int salary, int department, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.salary = salary;
        this.department = department;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && age == employee.age && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, salary, department, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", age=" + age +
                '}';
    }
}


