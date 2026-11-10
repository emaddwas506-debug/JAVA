import java.time.LocalDate; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator;
public class PayrollSystem {
public static void main(String[] args) {

    ArrayList<Employee> employees = new ArrayList<>();

    // Create employees

    employees.add(new FullTimeEmployee(
            "101", "Ali", 3000,
            LocalDate.of(2022, 1, 10), 500));

    employees.add(new FullTimeEmployee(
            "102", "Ahmed", 4000,
            LocalDate.of(2021, 5, 15), 700));

    employees.add(new ContractorEmployee(
            "103", "Omar",
            LocalDate.of(2023, 3, 20), 30, 100));

    employees.add(new ContractorEmployee(
            "104", "Mohamed",
            LocalDate.of(2020, 7, 5), 40, 120));

    double performanceScore = 4.5;

    // Sort by salary using Comparable

    Collections.sort(employees);

    System.out.println("Employees Sorted By Salary:");

    for (Employee e : employees) {
        System.out.println(e);
    }

    // Sort by join date using Comparator

    Comparator<Employee> dateComparator =
            Comparator.comparing(Employee::getJoinDate);

    employees.sort(dateComparator);

    System.out.println("\nEmployees Sorted By Join Date:");

    for (Employee e : employees) {
        System.out.println(e.getName()
                + " - " + e.getJoinDate());
    }

    // Calculate totals

    double totalSalary = 0;
    double totalTax = 0;
    double totalBonus = 0;

    for (Employee e : employees) {

        totalSalary += e.calculateNetSalary();

        totalTax += e.calculateTax();

        totalBonus += e.calculateBonus(performanceScore);
    }

    System.out.println("\nPayroll Summary:");

    System.out.println("Total Salary: " + totalSalary);

    System.out.println("Total Tax: " + totalTax);

    System.out.println("Total Bonus: " + totalBonus);
}
}