import java.util.*;

public class GroupAnagrams_LC49 {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
        System.out.println(result);
    }

    private static List<List<String>> groupAnagrams(String[] input) {
        if (input == null || input.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String word : input) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
            // computeIfAbsent
            // Get me the list for this key; if it doesn’t exist, make a new one. Then add this word to it.

            // before jdk 8 way
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(word);

        }
        return new ArrayList<>(map.values());
    }
}
