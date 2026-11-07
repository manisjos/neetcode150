import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepChar {
    public static void main(String[] args) {
        System.out.println(firstNonRepeating("swasti"));
        System.out.println(firstNonRepeating("ssaa"));
        System.out.println(conventionalWayOnePass("swasti"));
    }

    static Character conventionalWayOnePass(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        // notice the LinkedHashMap declaration
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // notice the iteration over the entrySet map - for loop
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            if (en.getValue() == 1) {
                return en.getKey();
            }
        }
        return null;
    }

    public static Character firstNonRepeating(String s) {
        // Your implementation
        return
                s.chars()
                        .mapToObj(x -> (char) x)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        ))
                        .entrySet()
                        .stream()
                        .filter(x -> x.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .skip(0)
                        .findFirst()
                        .orElse(null);
    }
}
