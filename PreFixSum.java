import java.util.HashMap;
import java.util.Map;

public class PreFixSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 7;
        System.out.println("Number of Subarr whose sum is K :" + findOutSubArrSum(arr, k));
    }

    static int findOutSubArrSum(int[] numbers, int targetSum) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int matchingSubArrCount = 0;
        int runningPrefixSum = 0;
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);

        for (int currNum : numbers) {
            runningPrefixSum += currNum;
            int requiredPrefixSum = runningPrefixSum - targetSum;
            if (prefixSumFreq.containsKey(requiredPrefixSum)) {
                matchingSubArrCount += prefixSumFreq.get(requiredPrefixSum);
            }

            prefixSumFreq.put(
                    runningPrefixSum,
                    prefixSumFreq.getOrDefault(runningPrefixSum, 0) + 1
            );
        }
        return matchingSubArrCount;
    }
}
