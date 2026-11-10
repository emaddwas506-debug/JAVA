import java.time.LocalDate;
public abstract class Employee implements Comparable<Employee>,Taxtble,  BonusCalculable {
private String id;
private String name;
protected double baseSalary;
private LocalDate joinDate;

public Employee(String id, String name,
                double baseSalary, LocalDate joinDate) {

    this.id = id;
    this.name = name;
    this.baseSalary = baseSalary;
    this.joinDate = joinDate;
}

public abstract double calculateNetSalary();

@Override
public double calculateTax() {
    double TAX_RATE = 0.15;
    return calculateNetSalary() * TAX_RATE;
}

@Override
public int compareTo(Employee other) {
    return Double.compare(
            other.calculateNetSalary(),
            this.calculateNetSalary()
    );
}

@Override
public abstract double calculateBonus(double performanceScore);

public String getId() {
    return id;
}

public String getName() {
    return name;
}

public double getBaseSalary() {
    return baseSalary;
}

public LocalDate getJoinDate() {
    return joinDate;
}

@Override
public String toString() {
    return "ID: " + id
            + ", Name: " + name
            + ", Salary: " + calculateNetSalary()
            + ", Tax: " + calculateTax();
}
}