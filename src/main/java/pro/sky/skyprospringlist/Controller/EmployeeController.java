package pro.sky.skyprospringlist.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringlist.Employee.Employee;
import pro.sky.skyprospringlist.Service.EmployeeService;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public String welcome() {

        employeeService.addListCollection();
        return employeeService.welcome();

    }

    @GetMapping(path = "/departments/allDepartment")
    public Stream<Employee> printAllDepartmentEmployees(@RequestParam("departmentId") Integer department) {

        return employeeService.printAllDepartment(department);

    }

    @GetMapping(path = "/departments/all")
    public Map<String, Employee> printAllEmployees() {

        return employeeService.printAll();
    }

    @GetMapping(path = "/addList")
    public boolean addListCollection() {

        return employeeService.addListCollection();

    }
    @GetMapping(path = "/addEmployee")
    public String addEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName,
                              @RequestParam("department") Integer department, @RequestParam("salary") double salary) {

        employeeService.addEmployee(fistName, lastName, department, salary);
        return "Employee " + fistName + " " + lastName + " Add";

    }

    @GetMapping(path = "/removeEmployee")
    public Employee removeEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName) {

        return employeeService.removeEmployee(fistName, lastName);

    }

    @GetMapping(path = "/searchEmployee")
    public Employee searchEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName) {

        return employeeService.searchEmployee(fistName,lastName);

    }

    @GetMapping(path = "/getWageFund")
    public Double getWageFund() {

        return employeeService.getWageFund();

    }

    @GetMapping(path = "/getDepartmentWageFund")
    public Double getDepartmentWageFund(@RequestParam("department") Integer department) {

        return employeeService.getDepartmentWageFund(department);

    }

    @GetMapping(path = "/departments/min-salary")
    public Optional<Employee> getMinSalaryEmployee(@RequestParam("departmentId") Integer department) {

        return employeeService.getMinSalaryEmployee(department);

    }

    @GetMapping(path = "/departments/max-salary")
    public Optional<Employee> getMaxSalaryEmployee(@RequestParam("departmentId") Integer department) {

        return employeeService.getMaxSalaryEmployee(department);

    }

    @GetMapping(path = "/getDownSalaryEmployee")
    public Stream<Employee> getDownSalaryEmployee(@RequestParam("salaryLevel") Double salaryLevel)  {

       return employeeService.getDownSalaryEmployee(salaryLevel);

    }


}
