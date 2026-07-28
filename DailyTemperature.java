import java.util.Arrays;

public class DailyTemperature {
    public static void main(String[] args) {
        int arr[] = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Array of Waits (BruteForce) : " + Arrays.toString(dailyWait(arr)));
    }

    static int[] dailyWait(int temperatures[]) {
//        Time : O(n²)
//        Space : O(1)
        int n = temperatures.length;
        int ans[] = new int[n];
        for (int currDay = 0; currDay < n; currDay++) {
            for (int futureDay = currDay + 1; futureDay < n; futureDay++) {
                if (temperatures[futureDay] > temperatures[currDay]) {
                    ans[currDay] = futureDay - currDay;
                    break;
                }
            }
        }
        return ans;
    }
}
