import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC3_LongestSubstrNonRep {
    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // 3
        System.out.println(lengthOfLongestSubStr(s)); // 3
        hashMapWay(s);
    }

    private static void hashMapWay(String s) {
        // johnway
        Map<Character, Integer> visitedCharMap = new HashMap<>();
        int maxLen = 0, leftPointer = 0;

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char currentChar = s.charAt(rightPointer);
            if (visitedCharMap.containsKey(currentChar) && visitedCharMap.get(currentChar) >= leftPointer) {
                leftPointer = visitedCharMap.get(currentChar) + 1;
            }
            maxLen = Math.max(maxLen, rightPointer - leftPointer + 1);
            visitedCharMap.put(currentChar, rightPointer);
        }
        System.out.println("Max Len: " + maxLen);
    }

    private static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int leftPointer = 0, maxLen = 0;

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            while (window.contains(s.charAt(rightPointer))) {
                window.remove(s.charAt(leftPointer));
                leftPointer++;
            }
            window.add(s.charAt(rightPointer));
            maxLen = Math.max(maxLen, rightPointer - leftPointer + 1);
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
