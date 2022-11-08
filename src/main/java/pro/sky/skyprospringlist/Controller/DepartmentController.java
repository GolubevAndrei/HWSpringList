package pro.sky.skyprospringlist.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringlist.Employee.Employee;
import pro.sky.skyprospringlist.Service.DepartmentService;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee/departments/")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping(path = "/allDepartment")
    public Stream<Employee> printAllDepartmentEmployees(@RequestParam("departmentId") Integer department) {

        return departmentService.printAllDepartment(department);

    }

    @GetMapping(path = "/all")
    public Map<String, Employee> printAllEmployees() {

        return departmentService.printAll();
    }

    @GetMapping(path = "/min-salary")
    public Optional<Employee> getMinSalaryEmployee(@RequestParam("departmentId") Integer department) {

        return departmentService.getMinSalaryEmployee(department);

    }

    @GetMapping(path = "/max-salary")
    public Optional<Employee> getMaxSalaryEmployee(@RequestParam("departmentId") Integer department) {

        return departmentService.getMaxSalaryEmployee(department);

    }
}
