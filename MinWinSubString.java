import java.util.HashMap;
import java.util.Map;

public class MinWinSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWinSub(s, t));
    }

    static String minWinSub(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> targetMap = new HashMap<>();

        // frequency map of chars in t
        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int required = targetMap.size();
        int formed = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            windowMap.put(currChar, windowMap.getOrDefault(currChar, 0) + 1);

            // did we satisfy this character ?
            if (targetMap.containsKey(currChar)
                    && windowMap.get(currChar).intValue() == targetMap.get(currChar).intValue()) {
                formed++;
            }

            // try shrinking
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar,windowMap.get(leftChar)-1);
                if (targetMap.containsKey(leftChar)
                        && windowMap.get(leftChar) < targetMap.get(leftChar)) {

                    formed--;
                }

                left++;

            }

        }
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}
