import java.time.LocalDate;
public class ContractorEmployee extends Employee {
private final int hourlyRate;
private int hoursWorked;

public ContractorEmployee(String id, String name,
                          LocalDate joinDate,
                          int hourlyRate,
                          int hoursWorked) {

    super(id, name, 0, joinDate);

    this.hourlyRate = hourlyRate;
    this.hoursWorked = hoursWorked;
}

@Override
public double calculateNetSalary() {
    return hourlyRate * hoursWorked;
}

@Override
public double calculateBonus(double performanceScore) {

    if (performanceScore > 4.0) {
        return 500;
    } else {
        return 0;
    }
}
}