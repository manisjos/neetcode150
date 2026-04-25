import java.util.Arrays;

public class LC239 {
    public static void main(String[] args) {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindowCostlyNaive(nums, k)));
    }

    static int[] maxSlidingWindowCostlyNaive(int arr[], int windowSize) {
        int totalNums = arr.length;
        int resultSize = totalNums - windowSize + 1;
        int[] maxValues = new int[resultSize];

        for (int winStart = 0; winStart < resultSize; winStart++) {
            int currMax = arr[winStart];

            for (int i = winStart; i < winStart + windowSize; i++) {
                currMax = Math.max(currMax, arr[i]);
            }
            maxValues[winStart] = currMax;
        }
        return maxValues;
    }
}
