package pro.sky.skyprospringlist.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringlist.Employee.Employee;
import pro.sky.skyprospringlist.Exeption.EmployeeNotFoundExeption;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String,Employee> employees = new HashMap<>();


    public String welcome() {
        return "Добро пожаловать";
    }
    @Override
    public Map<String, Employee> printAll() {
        return employees;
    }

    @Override
    public boolean addListCollection() {
        employees.put("Vasilii Sergeevich",new Employee("Vasilii", "Sergeevich"));
        employees.put("Vladimir Vasilievich",new Employee("Vladimir", "Vasilievich"));
        employees.put("Sergey Yusupovich",new Employee("Sergey", "Yusupovich"));
        employees.put("Andrey Volodimirovich",new Employee("Andrey", "Volodimirovich"));
        employees.put("Stepan Alexandrovich",new Employee("Stepan", "Alexandrovich"));
        employees.put("Alexander Stepanovich",new Employee("Alexander", "Stepanovich"));
        employees.put("Victor Olegovich",new Employee("Victor", "Olegovich"));
        employees.put("Oleg Victorovich",new Employee("Oleg", "Victorovich"));
        employees.put("Dmitrii ndreevich",new Employee("Dmitrii", "Andreevich"));
        employees.put("Fedor Dmitrievich",new Employee("Fedor", "Dmitrievich"));
        return true;
    }

    public void addEmployee(String fistName, String lastName) {
        employees.put(fistName + " " +  lastName, new Employee(fistName, lastName));

    }
    @Override
    public Employee removeEmployee(String fistName, String lastName) {
        if (employees.containsKey(fistName + " " +  lastName)) {
                employees.remove(fistName + " " +  lastName);
        }
        throw new EmployeeNotFoundExeption("Employee " + fistName + " " +  lastName + ": not found");
    }

    @Override
    public Employee searchEmployee(String fistName, String lastName) {
        if (employees.containsKey(fistName + " " +  lastName)) {
           return  employees.get(fistName + " " +  lastName);
        }

        throw new EmployeeNotFoundExeption("Employee " + fistName + " " +  lastName + ": not found");
    }

}
