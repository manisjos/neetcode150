import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortMapByOccurrenceClassic {
    public static void main(String[] args) {
        String input = "Programming";
        reverseSortedMap(input);

        System.out.println();
        System.out.println("Stream Way: ");
        reverseSortedMapStream(input);
    }

    static Map<Character,Long> reverseSortedMapStream(String input){

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
        return sortedMap;
    }

    static Map<Character, Integer> reverseSortedMap(String input) {
        // 1. Build Frequency Map
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 2. Convert EntrySet to List
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());

        // 3. Sort list by Value Descending
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // 4. Put back into a LinkedHashMap
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> en : entryList) {
            sortedMap.put(en.getKey(), en.getValue());
        }

        System.out.println("Sorted Map : " + sortedMap);
        return sortedMap;
    }
}
