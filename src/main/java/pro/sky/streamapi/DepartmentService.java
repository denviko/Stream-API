package pro.sky.streamapi;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    private EmployeeService employeeService;



    public Employee findMaxSalaryEmployee(int departmentId) {
        return EmployeeService.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }
    public Employee findMinSalaryEmployee(int departmentId) {
        return EmployeeService.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }

    public Collection<Employee> findByDepartment(int departmentId) {
        return EmployeeService.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> groupByDepartment() {
        return employeeService.getEmployees().values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}












