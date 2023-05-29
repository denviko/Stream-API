package pro.sky;

import pro.sky.streamapi.Employee;
import pro.sky.streamapi.EmployeeAlreadyAddedException;
import pro.sky.streamapi.EmployeeNotFoundException;
import pro.sky.streamapi.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

public class EmployeeService {
    private static final int SIZE = 10;
    private static final Map<String, Employee> employees = new HashMap<>();


    public Employee addEmployee(String firstName, String lastName, String middleName, int age) {
        var key = lastName + " " + firstName + " " + middleName;
        var employee = new Employee(firstName, lastName, middleName, 500, 2, age);
        if (employees.size() > SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(key, employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName, String middleName) {
        var key = lastName + " " + firstName + " " + middleName;
        var removed = employees.remove(key);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return removed;
    }

    public static Employee getEmployee(String firstName, String lastName, String middleName) {
        var key = lastName + " " + firstName + " " + middleName;
        var employee = employees.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public static Map<String, Employee> getEmployees() {
        return employees;
    }

}
