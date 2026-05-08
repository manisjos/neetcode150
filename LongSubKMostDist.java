import java.util.HashMap;
import java.util.Map;

public class LongSubKMostDist {
    public static void main(String[] args) {
        /*Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.

         */

        String s = "aabacbebebe";
        int k = 3;
        System.out.println("Length: " + lengthOfLongestSubstringKDistinct(s, k));
    }

    static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int left = 0;
        int maxLen = 0;
        // Map to Store Character frequency in the current window
        Map<Character, Integer> charCounts = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCounts.put(rightChar, charCounts.getOrDefault(rightChar, 0) + 1);


            // Shrink the window if we exceed K distinct chars
            while (charCounts.size() > k) {
                char leftChar = s.charAt(left);
                charCounts.put(leftChar, charCounts.get(leftChar) - 1);
                if (charCounts.get(leftChar) == 0) {
                    charCounts.remove(leftChar);
                }
                left++;
            }

            // calculate max length of a valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
