package pro.sky.streamapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee max(@RequestParam int departmentId) {
        return departmentService.findMaxSalaryEmployee(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee min(@RequestParam int departmentId) {
        return departmentService.findMinSalaryEmployee(departmentId);
    }

    @GetMapping( value = "/all", params = {"departmentId"})
    public Collection<Employee> all(@RequestParam int departmentId) {
        return departmentService.findByDepartment(departmentId);
    }
    @GetMapping( "/all")
    public Map<Integer, List<Employee>> group() {
        return departmentService.groupByDepartment();
    }


}
