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
    }
}
