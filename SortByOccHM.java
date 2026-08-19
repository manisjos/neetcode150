import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortByOccHM {
    public static void main(String[] args) {
        String input = "Programming";

        Map<Character,Long> frequencyMap = input.chars()
                        .mapToObj(x->(char)x)
                                .collect(Collectors.groupingBy(
                                        Function.identity(),
                                        LinkedHashMap::new,
                                        Collectors.counting()
                                ));

        Map<Character,Long> sortedMap = frequencyMap.entrySet()
                        .stream()
                                .sorted(Map.Entry.<Character,Long>comparingByValue().reversed())
                                        .collect(Collectors.toMap(
                                                Map.Entry::getKey,
                                                Map.Entry::getValue,
                                                (o,n)->o,
                                                LinkedHashMap::new
                                        ));

        System.out.println("Original Map: " + frequencyMap);
        System.out.println("Sorted Map:   " + sortedMap);
    }
}
