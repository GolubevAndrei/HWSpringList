package pro.sky.skyprospringlist.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringlist.Employee.Employee;
import pro.sky.skyprospringlist.Exeption.EmployeeNotFoundExeption;

import java.util.*;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String,Employee> employees = new HashMap<>();

    private final FIOService fioService;

    public EmployeeServiceImpl(FIOService fioService) {
        this.fioService = fioService;
    }


    public String welcome() {
        return "Добро пожаловать";
    }

    @Override
    public boolean addListCollection() {
        employees.put("Vasilii Sergeevich",new Employee("Vasilii", "Sergeevich", 1, 15000.0));
        employees.put("Vladimir Vasilievich",new Employee("Vladimir", "Vasilievich",  2, 18000.0));
        employees.put("Sergey Yusupovich",new Employee("Sergey", "Yusupovich",  5, 35000.0));
        employees.put("Andrey Volodimirovich",new Employee("Andrey", "Volodimirovich", 3, 45000.0));
        employees.put("Stepan Alexandrovich",new Employee("Stepan", "Alexandrovich", 5, 12800.0));
        employees.put("Alexander Stepanovich",new Employee("Alexander", "Stepanovich", 4, 11300.15));
        employees.put("Victor Olegovich",new Employee("Victor", "Olegovich", 4, 16750.0));
        employees.put("Oleg Victorovich",new Employee("Oleg", "Victorovich", 1, 23486.12));
        employees.put("Dmitrii Andreevich",new Employee("Dmitrii", "Andreevich", 3, 22594.38));
        employees.put("Fedor Dmitrievich",new Employee("Fedor", "Dmitrievich", 2, 36985.0));
        return true;
    }


    public Employee addEmployee(String fistName, String lastName, Integer department , double salary) {
       // employees.put(fioService.ChecName(fistName) + " " + fioService.ChecSureName(lastName),
        employees.put(fistName + " " + lastName,
                new Employee(
//                        fioService.ChecName(fistName),
//                        fioService.ChecSureName(lastName),
                        fistName,
                        lastName,
                        department,
                        salary));

        return employees.get(fistName + " " +  lastName);
    }

    @Override
    public Employee removeEmployee(String fistName, String lastName) {
        if (employees.containsKey(fistName + " " +  lastName)) {
                employees.remove(fistName + " " +  lastName);
        }
        //        throw new EmployeeNotFoundExeption("Employee " + fistName + " " +  lastName + ": not found");
        throw new EmployeeNotFoundExeption();
    }

    @Override
    public Employee searchEmployee(String fistName, String lastName) {
        if (employees.containsKey(fistName + " " +  lastName)) {
           return  employees.get(fistName + " " +  lastName);
        }

        //        throw new EmployeeNotFoundExeption("Employee " + fistName + " " +  lastName + ": not found");
        throw new EmployeeNotFoundExeption();
    }
    @Override
    public double getWageFund() {
      return employees.values().stream()
                .mapToDouble(e -> e.getSalary())
                .sum();
    }

    @Override
    public double getDepartmentWageFund(int department) {
     return employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(e -> e.getSalary())
                .sum();
    }

    @Override
    public Stream<Employee> getDownSalaryEmployee(double salaryLevel) {
     return employees.values().stream()
                .filter(e -> e.getSalary() < salaryLevel);

    }
    @Override
    public Stream<Employee> getUpSalaryEmployee(double salaryLevel) {
        return employees.values().stream()
                .filter(e -> e.getSalary() > salaryLevel);

    }
    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }


}
