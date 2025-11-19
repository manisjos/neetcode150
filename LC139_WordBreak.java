import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139_WordBreak {
    public static void main(String[] args) {
        System.out.println("Is wordbreak possible ? " + wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    private static boolean wordBreak(String String, List<String> wordDict) {

        boolean[] dp = new boolean[String.length() + 1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 1; i < String.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordSet.contains(String.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[String.length()];
    }
}
