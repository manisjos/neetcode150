import java.util.HashSet;
import java.util.Set;

public class LongestSubstrNonRep {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
    }

    private static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left=0, maxLen=0;
        for (int right = 0; right<s.length();right++){
            while (window.contains(s.charAt(right))){
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

}
