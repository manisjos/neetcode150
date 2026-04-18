import java.util.*;
import java.util.stream.Collectors;

public class LC49_GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
        List<List<String>> resultUsingStream = groupAnaUsingStream(input);
        System.out.println(result);

        System.out.println("Using Stream:");
        System.out.println(resultUsingStream);
    }

    private static List<List<String>> groupAnaUsingStream(String[] input) {
        List<List<String>> result = Arrays.stream(input).collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }))
                .values()
                .stream()
                .collect(Collectors.toList());


        List<List<String>> result1 = Arrays.stream(input).collect(Collectors.groupingBy(word -> {
                    int[] freq = new int[26];
                    for (char c : word.toCharArray()) {
                        freq[c - 'a']++;
                    }
                    return Arrays.toString(freq);
                }))
                .values()
                .stream()
                .collect(Collectors.toList());
        System.out.println("Optimal way:" + result1);
        return result;
    }

    private static List<List<String>> groupAnagrams(String[] input) {
        if (input == null || input.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String word : input) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
//            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
            // computeIfAbsent
            // Get me the list for this key; if it doesn’t exist, make a new one. Then add this word to it.

            // before jdk 8 way
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);

        }
        return new ArrayList<>(map.values());
    }
}
