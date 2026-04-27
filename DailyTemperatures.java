import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {

        int arr[] = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTempBruteForce(arr)));
        System.out.println(Arrays.toString(dailyTempOptimal(arr)));
    }

    static int[] dailyTempOptimal(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int prevIdx = stack.pop();
                result[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }
        return result;
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
