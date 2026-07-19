import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("HashSet way:");
        System.out.println("Length of Longest Substring is " + lenOfLongest(s) + ".");
        System.out.println("HashMap way:");
        System.out.println("Length of Longest Substring is " + lenOfLongestHashMap(s) + ".");

    }

    static int lenOfLongestHashMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);

            if (map.containsKey(curr)) {
                left = Math.max(left, map.get(curr) + 1);
            }

            map.put(curr, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    static int lenOfLongest(String s) {
        // O(n) solution
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }


}
