import java.util.HashMap;
import java.util.Map;

public class SubarrSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Result: " + subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, 2, 3, -2, 4};
        int k2 = 3;
        System.out.println("Result: " + subarraySum(nums2, k2));
    }

    static int subarraySum(int arr[], int k) {
        // map to store PrefixSum-> Freq

        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        // Base case: A prefix sum of 0 has occured once (before starting the array)
        prefixSumCounts.put(0, 1);
        int currPrefixSum = 0;
        int count = 0;

        for (int num : arr) {
            currPrefixSum += num;

            // check if an element exist in the map such that : cur
            int targetPrefixSum = currPrefixSum - k;
            if (prefixSumCounts.containsKey(targetPrefixSum)) {
                count += prefixSumCounts.get(targetPrefixSum);
            }

            // record/update the freq of the curr prefix sum
            prefixSumCounts.put(currPrefixSum, prefixSumCounts.getOrDefault(currPrefixSum, 0) + 1);

        }

        return count;
    }
}
