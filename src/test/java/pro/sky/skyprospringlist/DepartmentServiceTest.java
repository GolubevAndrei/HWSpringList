package pro.sky.skyprospringlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprospringlist.Employee.Employee;
import pro.sky.skyprospringlist.Exeption.EmployeeNotFoundExeption;
import pro.sky.skyprospringlist.Service.DepartmentServiceImpl;
import pro.sky.skyprospringlist.Service.EmployeeServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    public Map<String,Employee> employees = new HashMap<>();
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void beforeEach() {
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
        when(employeeService.getAll()).thenReturn((List<Employee>) employees);
    }

    @ParameterizedTest
    @MethodSource("EmployeeWithMaxSalaryParams")
    public void getMaxSalaryEmployeePositiveTest(int departmentId, Employee expected) {
        assertThat(departmentService.getMaxSalaryEmployee(departmentId)).isEqualTo(expected);
    }

    @Test
    public void getMaxSalaryEmployeeNegativeTest() {
        assertThatExceptionOfType(EmployeeNotFoundExeption.class)
                .isThrownBy(()-> departmentService.getMaxSalaryEmployee(3));
    }
    @ParameterizedTest
    @MethodSource("EmployeeWithMinSalaryParams")
    public void getMinSalaryEmployeePositiveTest(int departmentId, Employee expected) {
        assertThat(departmentService.getMinSalaryEmployee(departmentId)).isEqualTo(expected);
    }

    @Test
    public void getMinSalaryEmployeeNegativeTest() {
        assertThatExceptionOfType(EmployeeNotFoundExeption.class)
                .isThrownBy(()-> departmentService.getMinSalaryEmployee(3));
    }

//    @ParameterizedTest
//    @MethodSource("EmployeeWithMinSalaryParams")
//    public void getEmployeeDepartmentPositiveTest(int departmentId, HashMap<String, Employee> expected) {
//        assertThat(departmentService.printAllDepartment(departmentId)).containsExactlyelEmentsOf(expected);
//    }

    public static Stream<Arguments> EmployeeWithMaxSalaryParams() {
        return Stream.of(
                Arguments.of(1, new Employee("Oleg", "Victorovich", 1, 23486.12)),
                Arguments.of(2, new Employee("Fedor", "Dmitrievich", 2, 36985.0))
        );
    }

    public static Stream<Arguments> EmployeeWithMinSalaryParams() {
        return Stream.of(
                Arguments.of(1, new Employee("Vasilii", "Sergeevich", 1, 15000.0)),
                Arguments.of(2, new Employee("Vladimir", "Vasilievich",  2, 18000.0))
        );
    }
}
