package pro.sky.skyprospringlist.Service;


import pro.sky.skyprospringlist.Employee.Employee;

import java.util.List;
import java.util.stream.Stream;

public interface EmployeeService {

    String welcome();

    //Stream<Employee> printAllDepartment(int department);

    //public Map<String, Employee> printAll();

    public boolean addListCollection();

    Employee addEmployee(String fistName, String lastName, Integer department , double salary);
    Employee removeEmployee(String fistName, String lastName);
    Employee searchEmployee(String fistName, String lastName);

    double getWageFund();

    double getDepartmentWageFund(int department);

    //Optional<Employee> getMinSalaryEmployee(int department);

    Stream<Employee> getDownSalaryEmployee(double salaryLevel);


    Stream<Employee> getUpSalaryEmployee(double salaryLevel);

    List<Employee> getAll();

    //Optional<Employee> getMaxSalaryEmployee(int department);


}
