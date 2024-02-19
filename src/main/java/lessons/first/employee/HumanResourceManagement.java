package lessons.first.employee;

import java.util.ArrayList;
import java.util.List;
import lessons.first.employee.model.Employee;

public class HumanResourceManagement {
    private final List<Employee> employees;

    public HumanResourceManagement() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void editEmployeeByName(String name, String lastName,
                                   String newPosition, double newSalary) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getLastName().equals(lastName)) {
                employee.setPosition(newPosition);
                employee.setSalary(newSalary);
                break;
            }
        }
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }
}
