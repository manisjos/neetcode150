import java.util.Arrays;

public class DailyTemperatures {
    public static void main(String[] args) {

        int arr[] = {73, 74, 75};
        System.out.println(Arrays.toString(dailyTempBruteForce(arr)));
    }

    private static int[] dailyTempBruteForce(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
