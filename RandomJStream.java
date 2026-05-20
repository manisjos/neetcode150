import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RandomJStream {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 5, 1);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> dupes = nums.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());
        System.out.println("Duplicates: "+dupes);

        String str = "banana";
        Map<Object, Long> freqMap = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println("Frequency Map: "+freqMap);



        String s="swiss";
        Character result =s.chars()
                .mapToObj(ch->(char)ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(x->x.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First Non-Repeating Character -> "+result);


        List<Employee> employees
                = List.of(

                new Employee("Ramos",2,1100,"Lead Defender","Real Madrid"),
                new Employee("Beckham",1,1000,"Lead SE","Read Madrid"),
                new Employee("Zizzou",5,1700,"Midfielder","Real Madrid"),
                new Employee("Messi",6,1700,"Lead SE","Barcelona"),
                new Employee("Xabi",2,1770,"CF","Barcelona")
        );

        // group emps by dept
        Map<String,List<Employee>> group  = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment
                ));

        System.out.println("Group: "+group);


        List<String> words = Arrays.asList("apple","banana","kiwi");
        Map<String,Integer> wordLenMap = words.stream().collect(Collectors.toMap(
                Function.identity(),
                String::length
        ));
        System.out.println("Word Map : "+wordLenMap);

        Optional<String> longest = words.stream()
                .max(Comparator.comparing(String::length));
        System.out.println("Longest: " +longest.orElse(null));

        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1,2), Arrays.asList(3,4), Arrays.asList(5)
        );
        List<Integer> flattend = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flatted: "+flattend);

    }
}
