package pro.sky.skyprospringlist.Employee;

public class Employee {
    private String fistName;
    private String lastName;
    private int department;
    private double salary;


    public Employee(String fistName, String lastName, Integer department , double salary) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;

    }

    public String getFistName() {
        return fistName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getDepartment() {
        return department;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String toString() {
        return getFistName() + " " + getLastName();
    }

    public String getFullName() {
        return fistName + " " + lastName;
    }

    public String getFullData() {
        return getFistName() + " " + getLastName() + " "  + " " + getDepartment() + " " + getSalary();
    }

}
