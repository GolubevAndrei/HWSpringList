package pro.sky.skyprospringlist.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringlist.Employee.Employee;
import pro.sky.skyprospringlist.Exeption.EmployeeNotFoundExeption;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    public String welcome() {
        return "Добро пожаловать";
    }
    @Override
    public List<Employee> printAll() {
        return employees;
    }

    @Override
    public boolean addListCollection() {
        employees.add(new Employee("Vasilii", "Sergeevich"));
        employees.add(new Employee("Vladimir", "Vasilievich"));
        employees.add(new Employee("Sergey", "Yusupovich"));
        employees.add(new Employee("Andrey", "Volodimirovich"));
        employees.add(new Employee("Stepan", "Alexandrovich"));
        employees.add(new Employee("Alexander", "Stepanovich"));
        employees.add(new Employee("Victor", "Olegovich"));
        employees.add(new Employee("Oleg", "Victorovich"));
        employees.add(new Employee("Dmitrii", "Andreevich"));
        employees.add(new Employee("Fedor", "Dmitrievich"));
        return true;
    }

    public void addEmployee(String fistName, String lastName) {

        employees.add(new Employee(fistName, lastName) );

    }
    @Override
    public Employee removeEmployee(String fistName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFistName().equals(fistName)&&employees.get(i).getLastName().equals(lastName)) {
                employees.remove(i);
            }
        }
        throw new EmployeeNotFoundExeption("Employee " + fistName + " " +  lastName + ": not found");
    }

    @Override
    public Employee searchEmployee(String fistName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFistName().equals(fistName)&&employees.get(i).getLastName().equals(lastName)) {
                employees.get(i);
            }
        }
        throw new EmployeeNotFoundExeption("Employee " + fistName + " " +  lastName + ": not found");
    }
}
