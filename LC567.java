public class LC567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(containsCheckInc(s1, s2));
    }

    private static boolean containsCheckInc(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[c1[i] - 'a']++;
        }
        int winSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            int winIdx = 0, idx = i;
            int[] winFreq = new int[26];
            while (winIdx < winSize && idx < s2.length()) {
                winFreq[c2[idx] - 'a']++;
                winIdx++;
                idx++;
            }
            if (isSameFreq(freq, winFreq)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSameFreq(int[] f1, int[] f2) {
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }
        return true;
    }
}
