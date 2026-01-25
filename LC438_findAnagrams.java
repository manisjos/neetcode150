import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438_findAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
//        Output: [0,6]
//        Explanation:
//        The substring with start index = 0 is "cba", which is an anagram of "abc".
//        The substring with start index = 6 is "bac", which is an anagram of "abc".
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        // find all combinations of p
        // check if all combos are present in s, mark the present index if any and store in List to return it

        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill the frequency map for p and the first window of s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        // Check the first window
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Start sliding window
        for (int i = p.length(); i < s.length(); i++) {
            // Add new character (right side)
            sCount[s.charAt(i) - 'a']++;
            // Remove the old character (left side)
            sCount[s.charAt(i - p.length()) - 'a']--;

            // Compare counts
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
