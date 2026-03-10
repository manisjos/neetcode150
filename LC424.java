public class LC424 {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println("Longest: " + longestRepeatingCharRep(s, k));
    }

    private static int longestRepeatingCharRep(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            // update frequency of the current character
            count[s.charAt(right) - 'A']++;
            // keep track of most freq char in current window
            maxFrequency = Math.max(maxFrequency, count[s.charAt(right) - 'A']);
            // if (window size - maxFreq) > k, we have too many replacements to make
            while ((right - left + 1) - maxFrequency > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // calc the max length found so far
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
