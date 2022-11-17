package pro.sky.skyprospringlist.Service;

import pro.sky.skyprospringlist.Employee.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface DepartmentService {

    List<Employee> printAllDepartment(int department);

    Map<Integer, List<Employee>> printAll();

    Employee getMinSalaryEmployee(int department);

    Employee getMaxSalaryEmployee(int department);
}
