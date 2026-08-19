import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortByOccHM {
    public static void main(String[] args) {
        String input = "Programming";

        // Step 1: Count character frequencies while preserving original order
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        // Step 2: Sort entries by frequency descending and collect to LinkedHashMap
        Map<Character, Long> sortedMap = frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new // Preserves sorted order
                ));

        System.out.println("Original Map: " + frequencyMap);
        System.out.println("Sorted Map:   " + sortedMap);
    }
}
