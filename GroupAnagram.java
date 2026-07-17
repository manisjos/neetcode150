import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("BruteForce: "+groupOfAnaNaive(arr));
        System.out.println("Optimized: "+groupOfAnaOptimised(arr));
    }

    static List<List<String>> groupOfAnaOptimised(String arr[]) {

        Map<String, List<String>> map = new HashMap<>();
        for (String word : arr) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int val : count) {
                key.append('#').append(val);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    static List<List<String>> groupOfAnaNaive(String arr[]) {

//        Complexity
//
//        n = number of strings
//        m = average string length
//
//        Sorting one string
//        O(m log m)
//
//        Total
//        O(n * m log m)
//
//        Space
//        O(n)
        Map<String, List<String>> map = new HashMap<>();
        for (String word : arr) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
//            Or the Older way like below, instead of computeIfAbsent
//            List<String> list = map.get(key);
//            if (list == null) {
//                list = new ArrayList<>();
//                map.put(key, list);
//            }
//            list.add(word);
        }
        return new ArrayList<>(map.values());
    }


}
