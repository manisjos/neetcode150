import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC340_LongestSubstrKdist {

    //    Input: s = "aabacbebebe", k = 3
//    Output: 7
//    Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
//    Input: s = "aaaa", k = 2
//    Output: -1
//    Explanation: There's no substring with 2 distinct characters.
//    Input: s = "aabaaab", k = 2
//    Output: 7
//    Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println("Longest String with K distinct Characters: " + getLongSubstrKDist(s, k));
    }

    private static int getLongSubstrKDist(String s, int k) {
        if (k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);

            // shrink window if more than k distinct chars
            while (map.size() > k) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1); // reducing 1 from sliding window
                if (map.get(l) == 0) { // if 0 elements, just simply remove
                    map.remove(l);
                }
                left++; // increment the counter to move the window forward
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    private static int getLongSubstrKDist_StuggleMethod(String s, int k) {
        char[] charArr = s.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        int result = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (hs.size() < k) {

                if (hs.contains(charArr[right])) {
                    result += right - left + 1;
                }

            } else if (hs.size() <= k) {
                // remove from sliding window
                hs.add(charArr[result]);
            } else {
                hs.remove(charArr[left]);
                left++;
            }

        }
        return result;
    }
}
