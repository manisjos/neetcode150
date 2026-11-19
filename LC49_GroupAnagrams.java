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

            // get the list, if absent create a new arrlist and add word to it.
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);

            // before jdk 8 way
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(word);

        }
        return new ArrayList<>(map.values());
    }

    static List<List<String>> groupOfAnagramsV2(String[] arr) {
        if (arr == null || arr.length == 0) return new ArrayList<>();
        Map<String, List<String>> mapOfListOfWords = new HashMap<>();
        for (String word : arr) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr); // sort each unique word combo, to consider an anagram
//            Now building the key(of map) from current word
            String key = new String(charArr); // key built, now using it to add to map
            mapOfListOfWords.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
            // get the list, if absent create a new arrlist and add word to it.
        }
        return new ArrayList<>(mapOfListOfWords.values());
    }
}
