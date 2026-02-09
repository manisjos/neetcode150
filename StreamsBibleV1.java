import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsBibleV1 {

    public static void main(String[] args) {
        // --- DATA SETUP ---
        List<Employee> employees = Arrays.asList(
                new Employee("Ramos", 2, 1100, "Lead Defender", "Real Madrid"),
                new Employee("Beckham", 1, 1000, "Lead SE", "Real Madrid"),
                new Employee("Zizzou", 5, 1700, "Midfielder", "Real Madrid"),
                new Employee("Messi", 6, 1700, "Lead SE", "Barcelona"),
                new Employee("Xabi", 2, 1770, "CF", "Barcelona"),
                new Employee("Iniesta", 7, 1770, "Midfielder", "Barcelona")
        );
        List<Integer> nums = Arrays.asList(10, 20, 30, 10, 40, 20, 50);
        String inputStr = "swasti hitesh joshi";

        System.out.println("--- STARTING STREAMS BIBLE EXECUTION ---\n");

        // Q1: Find the frequency of each character in a string (excluding spaces).
        // Logic: chars() returns IntStream; mapToObj converts to Character; groupingBy/counting aggregates.
        Map<Character, Long> charFreq = inputStr.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // using Integer as a map value
        Map<Character, Integer> charFreq1 = inputStr.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c->1)));
        System.out.println("Q1 (Char Frequency): " + charFreq);

        // Q2: Find the first non-repeating character in a string.
        // Logic: Use LinkedHashMap to preserve insertion order; otherwise, HashMap will lose "first" position.
        Character firstUnique = inputStr.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
        System.out.println("Q2 (First Non-Repeating): " + firstUnique);


        // Q2.1: Find the Second non-repeating character in a string.
        // Logic: Use LinkedHashMap to preserve insertion order; otherwise, HashMap will lose "first" position.
        Character secondUnique = inputStr.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .skip(1).findFirst().orElse(null);
        System.out.println("Q2.1 (Second Non-Repeating): " + secondUnique);

        // Q3: Find the 2nd highest salary amount.
        // Logic: distinct() is crucial to handle cases where multiple employees share the top salary.
        Optional<Integer> secondHighSal = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println("Q3 (2nd Highest Salary Amount): " + secondHighSal.orElse(0));

        // Q4: Find the Employee with the highest salary in each department.
        // Logic: groupingBy with a downstream maxBy collector.
        Map<String, Optional<Employee>> topPaidByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        Map<String, String> topPaidByDept1 =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                        opt -> opt.map(Employee::getName).orElse(null)
                                )
                        ));


        System.out.println("Q4 (Top Paid per Dept): " + topPaidByDept);
        System.out.println("Q4.1 (Top Paid per Dept) - ONLY Name : " + topPaidByDept1);

        // Q5: Group all employee names by department.
        // Logic: mapping() transforms the stream element before it enters the list.
        Map<String, List<String>> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Q5 (Names per Dept): " + namesByDept);

        // Q6: Flatten a list of roles into unique words.
        // Logic: flatMap "unrolls" the arrays into a single stream of strings.
        List<String> uniqueRoleWords = employees.stream()
                .map(Employee::getRole)
                .flatMap(role -> Arrays.stream(role.split(" ")))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Q6 (Unique Role Words): " + uniqueRoleWords);

        // Q7: Get summary statistics (min, max, avg, sum) for salaries.
        // Logic: summaryStatistics() only exists on primitive streams (IntStream/LongStream).
        IntSummaryStatistics stats = employees.stream()
                .mapToInt(Employee::getSalary)
                .summaryStatistics();
        System.out.println("Q7 (Salary Stats): Avg=" + stats.getAverage() + ", Max=" + stats.getMax());

        // Q8: Partition employees into those earning > 1500 and those not.
        // Logic: partitioningBy always returns a Map with exactly two keys: true and false.
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 1500));
        System.out.println("Q8 (High Earners vs Low): " + partitioned);

        // Q9: Find all duplicate elements in a list.
        // Logic: Set.add() returns false if the element is already present.
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = nums.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toList());
        System.out.println("Q9 (Duplicates found): " + duplicates);

        // Q10: Generate the first 10 Fibonacci numbers using Stream.iterate.
        // Logic: iterate creates an infinite stream; limit(10) truncates it.
        List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(10)
                .map(f -> f[0])
                .collect(Collectors.toList());
        System.out.println("Q10 (Fibonacci Series): " + fibonacci);

        // Q11: Concatenate all employee names into a single string.
        // Logic: joining() is the most efficient way to build delimited strings.
        String joinedNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "All: [", "]"));
        System.out.println("Q11 (Joined Names): " + joinedNames);

        // Q12: Check if any employee is from Barcelona (anyMatch).
        // Logic: anyMatch is "short-circuiting"—it stops searching as soon as it finds one.
        boolean anyBarcelona = employees.stream().anyMatch(e -> "Barcelona".equals(e.getDepartment()));
        System.out.println("Q12 (Any Barcelona?): " + anyBarcelona);

        // Q13: Convert employees to Map<Id, Name> (handle duplicates)
        Map<Integer, String> empMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getName,
                        (oldVal, newVal) -> oldVal // merge strategy
                ));
        System.out.println("Convert employees to Map<Id, Name> (handle duplicates) : " + empMap);

        // Q14: Max salary using reduce
        System.out.println("Max salary using reduce : ");
        System.out.println(employees.stream().map(Employee::getSalary).reduce(0, Integer::max));


        List<Employee> top3 = employees
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Q15: Top 3 highest paid employees: " + top3);

        // Q16: Group by Dept → Role
        Map<String, Map<String, List<String>>> multiGroup =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getRole,
                                Collectors.mapping(Employee::getName, Collectors.toList()))));
        System.out.println("Q16: Group by Dept → Role: \n " + multiGroup);


        // Q17: Safely get highest salary
        Optional<Integer> maxSal =
                employees.stream()
                        .map(Employee::getSalary)
                        .max(Integer::compare);
        System.out.println("Q17: Safely get highest salary - ");
        maxSal.ifPresent(System.out::println);


        // Q18: Parallel sum
        int sum = nums.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Q18 Parallel sum : " + sum);


        // Q19: Are all employees earning > 900?
        boolean allHigh = employees.stream()
                .allMatch(e -> e.getSalary() > 1800);

        // Q20: No one earns < 500?
        boolean noneLow = employees.stream()
                .noneMatch(e -> e.getSalary() < 500);

        System.out.println("Q19, Q20 -> all match: " + allHigh + ", None Match: " + noneLow);

        Map<String, Map<String, Integer>> salaryByDept =
        employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary))));
        System.out.println("Q21 Salary by Dept: " + salaryByDept);

    }
}
