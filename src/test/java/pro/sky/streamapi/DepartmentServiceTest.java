package pro.sky.streamapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.sky.EmployeeService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DepartmentServiceTest {
    @Mock
    EmployeeService employeeServiceMock;
    DepartmentService service = new DepartmentService();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new DepartmentService(employeeServiceMock);
    }


    @Test
    void findMaxSalaryEmployee() {
        List<Employee> employees = List.of(
                new Employee("Pyotvr", "Petrov", "Petrovich",  10, 1,15),
                new Employee("Pyotfr", "Petrov", "Petrovich", 100, 10, 150),
                new Employee("Pyotfffr", "Petrov", "Petrovich", 101, 10, 150));
        when(employeeServiceMock.getEmployees()).thenReturn(employees);

        assertNull(service.findMaxSalaryEmployee(5));
        var expectedMaxSalary = new Employee("Pyotfffr", "Petrov", "Petrovich", 101, 10, 150);
        assertEquals(expectedMaxSalary, service.findMaxSalaryEmployee(10));

    }

    @Test
    void findMinSalaryEmployee() {
        List<Employee> employees = List.of(
                new Employee("Pyotvr", "Petrov", "Petrovich",  10, 1,15),
                new Employee("Pyotfr", "Petrov", "Petrovich", 100, 10, 150),
                new Employee("Pyotfffr", "Petrov", "Petrovich", 101, 10, 150));
        when(employeeServiceMock.getEmployees()).thenReturn(employees);

        assertNull(service.findMinSalaryEmployee(5));
        var expectedMaxSalary = new Employee("Pyotfffr", "Petrov", "Petrovich", 100, 10, 150);
        assertEquals(expectedMaxSalary, service.findMinSalaryEmployee(10));
    }

    @Test
    void findByDepartment() {
        List<Employee> employees = List.of(
                new Employee("Pyotvr", "Petrov", "Petrovich",  10, 1,15),
                new Employee("Pyotfr", "Petrov", "Petrovich", 100, 10, 150),
                new Employee("Pyotfffr", "Petrov", "Petrovich", 101, 10, 150));
        when(employeeServiceMock.getEmployees()).thenReturn(employees);
        var actualList = service.findByDepartment(10);
        assertEquals(2,actualList.size());

        var expectedList = List.of(
                new Employee("Pyotfr", "Petrov", "Petrovich", 100, 10, 150),
                new Employee("Pyotfffr", "Petrov", "Petrovich", 101, 10, 150));
        assertIterableEquals(actualList,actualList);
    }

    @Test
    void groupByDepartment() {
        List<Employee> employees = List.of(
                new Employee("Pyotvr", "Petrov", "Petrovich",  10, 1,15),
                new Employee("Pyotfr", "Petrov", "Petrovich", 100, 10, 150),
                new Employee("Pyotfffr", "Petrov", "Petrovich", 101, 10, 150));
        when(employeeServiceMock.getEmployees()).thenReturn(employees);

        Map<Integer, List<Employee>> actual = service.groupByDepartment();
        assertEquals(2,actual.size());
        assertEquals(1,actual.get(1).size());
        assertEquals(2,actual.get(10).size());

        assertEquals(new Employee("Pyotvr", "Petrov", "Petrovich",  10, 1,15),actual.get(1).size());
        assertIterableEquals(
                List.of(new Employee("Pyotfr", "Petrov", "Petrovich", 100, 10, 150),
                        new Employee("Pyotfffr", "Petrov", "Petrovich", 101, 10, 150)),
                        actual.get(10));


    }
}