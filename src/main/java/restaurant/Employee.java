package restaurant;

/**
 * Created by sky on 05/06/15.
 */
public final class Employee {
    public enum EmployeeType {
        HOST,
        ATTENDANT;
    }

    private final String name;
    private final EmployeeType employeeType;

    public Employee(String name, EmployeeType employeeType) {
        this.name = name;
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
}
