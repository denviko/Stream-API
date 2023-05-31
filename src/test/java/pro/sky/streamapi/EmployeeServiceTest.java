package pro.sky.streamapi;

import org.junit.jupiter.api.Test;
import pro.sky.EmployeeService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceTest {
    EmployeeService service = new EmployeeService();

    @Test
    void nameAdd() {
        var expected = new Employee("Ivan", "Ivanov", "Ivanovich", 500, 2, 30);
        var actual = service.addEmployee("Ivan", "Ivanov", "Ivanovich", 500, 2, 30);
        assertEquals(expected, actual);
    }

    @Test
    void testAlreadyAdded() {
        service.addEmployee("Ivan", "Ivanov", "Ivanovich", 500, 2, 30);
        assertThrows(EmployeeAlreadyAddedException.class, () -> service.addEmployee("Ivan", "Ivanov", "Ivanovich", 500, 2, 30));
    }

    @Test
    void testStorageIsFull() {
        service.addEmployee("Pyotvr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyotfr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyotfffr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyetr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyoter", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyodetr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyotwr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyotr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyoktr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyvoefefetr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyoftr", "Petrov", "Petrovich", 650, 3, 45);
        assertThrows(EmployeeStorageIsFullException.class, () -> service.addEmployee("Ivan", "Ivanov", "Ivanovich", 500, 2, 30));
    }

    @Test
    void testGetAll() {
        service.addEmployee("Pyotvr", "Petrov", "Petrovich", 650, 3, 45);
        service.addEmployee("Pyotfr", "Petrov", "Petrovich", 650, 3, 45);
        Collection<Employee>employees = EmployeeService.getEmployees();
        assertEquals(2,employees.size());
    }

    @Test
    void testGetAllIsEmpty() {
        assertEquals(0, EmployeeService.getEmployees().size());
    }
}






