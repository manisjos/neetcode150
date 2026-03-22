public class LC72 {
    public static void main(String[] args) {
//        String word1 = "horse";
//        String word2 = "ros";
        String word1 = "car";
        String word2 = "cat";
        System.out.println("Minimal effort: " + minDistance(word1, word2));
    }

    static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];


        // Base case: converting a string to an empty string requires i deletions
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Base case: converting an emptry string to word2 requires j insertions
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // characters match, no new operations needed.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }
}
