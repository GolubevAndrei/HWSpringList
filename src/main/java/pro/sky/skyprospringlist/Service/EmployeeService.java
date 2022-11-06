package pro.sky.skyprospringlist.Service;


import pro.sky.skyprospringlist.Employee.Employee;

import java.util.Map;

public interface EmployeeService {

    String welcome();
    public Map<String, Employee> printAll();

    public boolean addListCollection();

    void addEmployee(String fistName, String lastName);
    Employee removeEmployee(String fistName, String lastName);
    Employee searchEmployee(String fistName, String lastName);

}
