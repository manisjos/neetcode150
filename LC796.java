public class LC796 {
    public static void main(String[] args) {
        String s = "abcde";
        String goals = "bcdea";
        int arr1[] = {1, 2, 3, 2, 1};
        int arr2[] = {3, 2, 1, 4, 7};
        System.out.println(
                rotateString(s, goals));
        System.out.println(
                maxSubArrLC718(arr1, arr2));
    }

    private static int maxSubArrLC718(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr1.length;
        int ans=0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        s = s + s;
        return s.contains(goal);
    }
}
