import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC159 {
    //    Given a string s, return the length of the longest substring that contains at most two distinct characters.
//           Example 1:
//    Input: s = "eceba"
//    Output: 3
//    Explanation: The substring is "ece" which its length is 3.
//    Example 2:
//    Input: s = "ccaabbb"
//    Output: 5
//    Explanation: The substring is "aabbb" which its length is 5.
//    Constraints:
//            1 <= s.length <= 105
//    s consists of English letters.
    public static void main(String[] args) {
        String s = "ccaabbb";
//        List<String> ls = List.of("s", "ccaabbb");
//        for (String s1 : ls) {
            longestSubStr2DisChars(s);
//        }
    }

    private static void longestSubStr2DisChars(String s) {
        int left = 0;
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightPointer = s.charAt(right);

            // 1. Expand window
            map.put(rightPointer, map.getOrDefault(rightPointer, 0) + 1);

            // 2. Shrink if invalid (> 2 distinct)
            while (map.size() > 2) {
                char leftPointer = s.charAt(left);
                map.put(leftPointer, map.get(leftPointer) - 1);

                if (map.get(leftPointer) == 0) {
                    map.remove(leftPointer);
                }
                left++;
            }

            // 3. Update result
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println("Max Len: " +maxLen);
    }
}
