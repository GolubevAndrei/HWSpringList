package pro.sky.skyprospringlist.Service;


import pro.sky.skyprospringlist.Employee.Employee;

import java.util.List;

public interface EmployeeService {

    String welcome();
    public List<Employee> printAll();

    public boolean addListCollection();

    void addEmployee(String fistName, String lastName);
    Employee removeEmployee(String fistName, String lastName);
    Employee searchEmployee(String fistName, String lastName);
}
