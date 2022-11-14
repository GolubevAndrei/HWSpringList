package pro.sky.skyprospringlist.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringlist.Employee.Employee;
import pro.sky.skyprospringlist.Exeption.EmployeeNotFoundExeption;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> printAllDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department).toList();
    }

    @Override
    public Map<Integer, List<Employee>> printAll() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee getMinSalaryEmployee(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundExeption::new);

    }

    @Override
    public Employee getMaxSalaryEmployee(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundExeption::new);

    }
}
