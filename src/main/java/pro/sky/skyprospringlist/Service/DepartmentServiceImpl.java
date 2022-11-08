package pro.sky.skyprospringlist.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringlist.Employee.Employee;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    EmployeeServiceImpl empl = new EmployeeServiceImpl();

    public Map<String, Employee> employees = empl.employees;

    @Override
    public Stream<Employee> printAllDepartment(int department) {
        empl.addListCollection();
        return  employees.values().stream()
                .filter(e -> e.getDepartment() == department);
    }

    @Override
    public Map<String, Employee> printAll() {
        empl.addListCollection();
        return employees;
    }

    @Override
    public Optional<Employee> getMinSalaryEmployee(int department) {
        empl.addListCollection();
        return employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary));

    }

    @Override
    public Optional<Employee> getMaxSalaryEmployee(int department) {
        empl.addListCollection();
        return employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary));

    }
}
