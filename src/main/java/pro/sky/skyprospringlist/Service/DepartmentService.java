package pro.sky.skyprospringlist.Service;

import pro.sky.skyprospringlist.Employee.Employee;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public interface DepartmentService {

    Stream<Employee> printAllDepartment(int department);

    Map<String, Employee> printAll();

    Optional<Employee> getMinSalaryEmployee(int department);

    Optional<Employee> getMaxSalaryEmployee(int department);
}
