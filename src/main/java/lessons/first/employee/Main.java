package lessons.first.employee;

import lessons.first.employee.model.AccountingDepartment;
import lessons.first.employee.model.Employee;
import lessons.first.employee.model.EngineeringDepartment;
import lessons.first.employee.model.ManagementDepartment;

public class Main {
    public static void main(String[] args) {
        Employee john = new EngineeringDepartment("John", "Bobson",
                "Software Engineer", 3000);
        Employee alise = new ManagementDepartment("Alice", "Johnson",
                "Project Manager", 4000);
        Employee bob = new AccountingDepartment("Bob", "Alison",
                "Accountant", 3500);

        HumanResourceManagement hr = new HumanResourceManagement();

        hr.addEmployee(john);
        hr.addEmployee(alise);
        hr.addEmployee(bob);

        // Виводимо усіх працівників та загальну зарплату
        System.out.println(hr.getEmployees());
        System.out.println("Total salary: $" + hr.calculateTotalSalary());

        // Змінюємо дані працівника на основі ім'я та прізвища
        hr.editEmployeeByName("John", "Bobson",
                "Front-end developer", 3700);

        // Виводимо усіх працівників та загальну зарплату після зміни цих даних
        System.out.println(hr.getEmployees());
        System.out.println("Total salary: $" + hr.calculateTotalSalary());
    }
}
