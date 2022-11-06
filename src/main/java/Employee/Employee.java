package Employee;

public class Employee {
    private String fistName;
    private String lastName;

    public Employee(String fistName, String lastName, String middleName, int department, double salary) {
        this.fistName = fistName;
        this.lastName = lastName;

    }
    public String getFistName() {

        return fistName;
    }

    public String getLastName() {

        return lastName;
    }

    public String toString() {
        return getFistName() + " " + getLastName();
    }

    public String getFullName() {

        return getFistName() + " " + getLastName();
    }

    public String getFullData() {
        return getFistName() + " " + getLastName();
    }
}
