import java.util.HashMap;
import java.util.Map;

public class Test1 {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 7;
        System.out.println("Number of Subarr whose sum is K " + findOutSubArrSum(arr, k));
    }

    static int findOutSubArrSum(int[] arr, int k) {
        int count = 0;
        int currSum = 0;

        // Map stores: <PrefixSum, Frequency>
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base case: A prefix sum of 0 has occurred once (for subarray starting at index 0)
        prefixSumMap.put(0, 1);

        for (int num : arr) {
            currSum += num;
            // Check if there is a previous prefix sum such that "currSum-prevSum=k"
            if (prefixSumMap.containsKey(currSum - k)) {
                count += prefixSumMap.get(currSum - k);
            }

            // Record the current prefixSum in the map
            prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }

}
