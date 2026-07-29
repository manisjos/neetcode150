import java.util.Arrays;

public class DailyTemperature {
    public static void main(String[] args) {
        int arr[] = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Array of Waits (BruteForce) : " + Arrays.toString(dailyWait(arr)));
        System.out.println("Array of Waits (Optimal) : " + Arrays.toString(dailyWaitOptimal(arr)));
    }

    static int[] dailyWaitOptimal(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        // Use an array to simulate stack mechanics
        int[] stack = new int[n];
        int top = -1;

        for (int currentDay = 0; currentDay < n; currentDay++) {
            // Resolve all previous colder days
            while (top >= 0 && temperatures[currentDay] > temperatures[stack[top]]) {
                int previousDay = stack[top--]; // pop
                answer[previousDay] = currentDay - previousDay;
            }

            // Push current day onto stack
            stack[++top] = currentDay;
        }

        return answer;
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
