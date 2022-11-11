package pro.sky.skyprospringlist.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundExeption extends RuntimeException {
//    public EmployeeNotFoundExeption(String message) {
//
//        super(message);
//
//    }
}
