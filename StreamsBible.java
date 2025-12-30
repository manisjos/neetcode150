import jdk.jfr.Frequency;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsBible {

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        String s = "Swasti Jishant Krishvi";

        System.out.println(ls.stream().filter(x -> x % 2 != 0).collect(Collectors.toList()));
        List<Integer> even = ls.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(even);

//        Frequency of chars in string
        Map<Character,Long> freq =
        s.toUpperCase(Locale.ROOT).chars().mapToObj(c->(char)c)
                .filter(c->c!=' ')
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println("Printing Map: "+freq);

        String str="tatol";
//        First Non repeating Character
        Character res = str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
        System.out.println(res);


        List<Employee> employees
                = List.of(

                new Employee("Ramos",2,1100,"Lead Defender","Real Madrid"),
                new Employee("Beckham",1,1000,"Lead SE","Read Madrid"),
                new Employee("Zizzou",5,1700,"Midfielder","Real Madrid"),
                new Employee("Messi",6,1700,"Lead SE","Barcelona"),
                new Employee("Xabi",2,1770,"CF","Barcelona")
        );
        System.out.println("=========Printing Employee by Salary===================");
        employees.stream().sorted(Comparator.comparing(Employee::getId).reversed()).forEach(
                e-> System.out.println(e.getName()+" : "+e.getDepartment()+" : "+e.getSalary())
        );

//        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        Optional<Integer> secondHighSal =
                employees.stream().
                        map(Employee::getSalary).distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1).findFirst();
        System.out.println("Second High Salary Amount: "+secondHighSal);


        Optional<Employee> secondHighSalEmp =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getSalary))
                                .entrySet().stream()
                                .sorted(Map.Entry.<Integer,List<Employee>>comparingByKey().reversed())
                                        .skip(1)
                                                .map(entry->entry.getValue().get(0))
                                                        .findFirst();
        System.out.println("Second high emp details (prints only 1) : "+secondHighSalEmp.get().toString());

        Optional<List<Employee>> secHighEmps =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getSalary))
                        .entrySet().stream()
                        .sorted(Map.Entry.<Integer,List<Employee>>comparingByKey().reversed())
                        .skip(1)
                        .map(Map.Entry::getValue)
                        .findFirst();

        System.out.println("Printing all employees with 2nd High Sal: ");
        secHighEmps.ifPresent(x->x.forEach(System.out::println));

        Comparator<Employee> comparingBySal = Comparator.comparing(Employee::getRole);

        Map<String, Optional<Employee>> empName = employees.stream()
                .collect(
                        Collectors.groupingBy
                                (Employee::getDepartment, Collectors.reducing(BinaryOperator.maxBy(comparingBySal))));

        System.out.println("\n Departmentwise High Salary "+empName);

        Map<Integer,Employee> map =
                employees.stream().collect(Collectors.toMap(
                        Employee::getId,
                        Function.identity(),
                        (e1,e2)->e1
                ));
        System.out.println("printing map "+map);


        // group employees by department
        System.out.println("\n\n");
        System.out.println("group employees by department");
        Map<String,List<Employee>> deptMap =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));


        Map<String,List<String>> deptMap1 =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment
                ,Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println("\n\n");
        System.out.println("group employees names by department");
        System.out.println(deptMap1);


        String input= "swasti hitesh joshi";
        Map<String,Long> countMap =
        Arrays.stream(input.split("")).filter(x->!x.equals(" "))
                .collect(
                    Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
                    )
                );
        System.out.println(countMap);

    }
}
