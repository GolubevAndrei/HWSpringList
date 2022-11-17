package pro.sky.skyprospringlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.skyprospringlist.Employee.Employee;
import pro.sky.skyprospringlist.Exeption.EmployeeNotFoundExeption;
import pro.sky.skyprospringlist.Exeption.IncorrectFIOExeption;
import pro.sky.skyprospringlist.Service.EmployeeServiceImpl;
import pro.sky.skyprospringlist.Service.FIOService;


import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class EmployeeServiceTest {

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(new FIOService());

    @AfterEach
    public void afterEach() {
       employeeService.getAll().forEach(employee -> employeeService.removeEmployee(employee.getFistName(), employee.getLastName()));
    }

    @ParameterizedTest
    @MethodSource("params")
    public void addNegativeTest(String name,
                                String surname,
                                int department,
                                double salary) {

        Employee expected = new Employee(name, surname, department, salary);

        assertThat(employeeService.getAll().isEmpty());
        employeeService.addEmployee(name, surname, department, salary);
//        assertThat(employeeService.getAll())
//                .hasSize(1)
//                .containsExactly(expected);
//        assertThat(employeeService.searchEmployee(expected.getFistName(), expected.getLastName()))
//                .isNotNull()
//                .isEqualTo(expected);
        assertThat(employeeService.addEmployee(expected.getFistName(), expected.getLastName(),expected.getDepartment(),expected.getSalary()))
                .isEqualTo(expected);


    }

    public void addNegativeTest2() {

        assertThatExceptionOfType(IncorrectFIOExeption.class)
                .isThrownBy(()-> employeeService.addEmployee("Nikolay5", "Petrov", 1, 35000.0));
        assertThatExceptionOfType(IncorrectFIOExeption.class)
                .isThrownBy(()-> employeeService.addEmployee("!Yrii", "Ivanov", 1, 45000.0));
        assertThatExceptionOfType(IncorrectFIOExeption.class)
                .isThrownBy(()-> employeeService.addEmployee(null, "Petrov", 1, 35000.0));


    }

    @ParameterizedTest
    @MethodSource("params")
    public void removeNegativeTest(String name,
                                String surname,
                                int department,
                                double salary) {
        assertThatExceptionOfType(EmployeeNotFoundExeption.class)
                .isThrownBy(()-> employeeService.removeEmployee("test", "Petrov"));
        Employee expected = new Employee(name, surname, department, salary);
        assertThat(employeeService.addEmployee(name, surname, department, salary))
                .isEqualTo(expected);
        assertThatExceptionOfType(EmployeeNotFoundExeption.class)
                .isThrownBy(()-> employeeService.removeEmployee("test", "Petrov"));

    }

    @ParameterizedTest
    @MethodSource("params")
    public void removePositiveTest(String name,
                                   String surname,
                                   int department,
                                   double salary) {
        Employee expected = new Employee(name, surname, department, salary);
        assertThat(employeeService.addEmployee(name, surname, department, salary))
                .isEqualTo(expected);
        assertThatExceptionOfType(EmployeeNotFoundExeption.class)
                .isThrownBy(()-> employeeService.removeEmployee(name, surname)).isEqualTo(expected);
        assertThat(employeeService.getAll().isEmpty());

    }

    @ParameterizedTest
    @MethodSource("params")
    public void findNegativeTest(String name,
                                   String surname,
                                   int department,
                                   double salary) {
        assertThatExceptionOfType(EmployeeNotFoundExeption.class)
                .isThrownBy(()-> employeeService.removeEmployee("test", "Petrov"));
        Employee expected = new Employee(name, surname, department, salary);
        assertThat(employeeService.addEmployee(name, surname, department, salary))
                .isEqualTo(expected);
        assertThatExceptionOfType(EmployeeNotFoundExeption.class)
                .isThrownBy(()-> employeeService.searchEmployee("test", "Petrov"));

    }

    @ParameterizedTest
    @MethodSource("params")
    public void findPositiveTest(String name,
                                 String surname,
                                 int department,
                                 double salary) {
        assertThat(employeeService.getAll().isEmpty());
        Employee expected = new Employee(name, surname, department, salary);
        assertThat(employeeService.addEmployee(name, surname, department, salary))
                .isEqualTo(expected);
        assertThatExceptionOfType(EmployeeNotFoundExeption.class)
                .isThrownBy(()-> employeeService.searchEmployee(name, surname));

    }


    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("Nikolay", "Petrov", 1, 35000.0),
                Arguments.of("Yrii", "Ivanov", 1, 45000.0),
                Arguments.of("Sergey", "Titov", 2, 55000.0)
        );
    }
}
