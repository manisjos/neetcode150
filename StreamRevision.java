import java.util.*;
import java.util.stream.Collectors;

public class StreamRevision {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Ramos", 2, 1100, "Lead Defender", "Real Madrid"),
                new Employee("Beckham", 1, 1000, "Lead SE", "Real Madrid"),
                new Employee("Zizzou", 5, 1700, "Midfielder", "Real Madrid"),
                new Employee("Messi", 6, 1700, "Lead SE", "Barcelona"),
                new Employee("Xabi", 2, 1770, "CF", "Barcelona"),
                new Employee("Iniesta", 7, 1770, "Midfielder", "Barcelona")
        );

        Map<String, Optional<Employee>> highPaidByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                        ));

        System.out.println("Highest Paid By Dept: "+highPaidByDept);
    }
}
