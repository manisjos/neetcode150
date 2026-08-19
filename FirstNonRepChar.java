import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepChar {
    public static void main(String[] args) {
        String input = "swiss";
        System.out.println("Array Approach 256 (most optimal) since its all ASCII chars: " + findFirstNonArr(input));
        System.out.println("Array Approach 26 (only lowercase a-z): " + findFirstNonArr26(input));
        System.out.println("Streams Approach: " + findFirstNonRepeatingStream(input));
    }

    static Character findFirstNonRepeatingStream(String str) {

        return
                str.chars().mapToObj(x -> (char) x)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )).entrySet()
                        .stream()
                        .filter(x -> x.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(null);
    }

    static Character findFirstNonArr(String str) {
        // Approach 1: Frequency Array (Optimal for Standard ASCII - O(N) Time, O(1) Space)
        if (str == null || str.isEmpty()) {
            return null;
        }
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }

    static Character findFirstNonArr26(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i) - 'a'] == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }
}
