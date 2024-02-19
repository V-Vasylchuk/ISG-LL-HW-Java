package lessons.first.employee.model;

public class Employee {
    private final String name;
    private final String lastName;
    private String position;
    private double salary;

    public Employee(String name, String lastName, String position, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }

    public double calculateSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    public String getPosition() {
        return position;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", lastName='" + lastName + '\''
                + ", position='" + position + '\''
                + ", salary=" + salary
                + '}';
    }
}
