package pro.sky.skyprospringlist.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringlist.Employee.Employee;
import pro.sky.skyprospringlist.Service.EmployeeService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public String welcome() {

        return employeeService.welcome();

    }

    @GetMapping(path = "/printAll")
    public Map<String, Employee> printAllEmployees() {

        return employeeService.printAll();
    }

    @GetMapping(path = "/addList")
    public boolean addListCollection() {

        return employeeService.addListCollection();

    }
    @GetMapping(path = "/addEmployee")
    public String addEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName) {

        employeeService.addEmployee(fistName, lastName);
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
}
