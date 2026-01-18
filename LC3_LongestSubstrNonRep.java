import java.util.HashSet;
import java.util.Set;

public class LC3_LongestSubstrNonRep {
    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // 3
        System.out.println(lengthOfLongestSubStr(s)); // 3
    }

    private static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubStr(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }

}
