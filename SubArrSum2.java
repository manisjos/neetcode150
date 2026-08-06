import java.util.HashMap;
import java.util.Map;

public class SubArrSum2 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int k = 3;

        System.out.println("SubArr Sum: " + subArrSum(arr, k));
    }

    static int subArrSum(int arr[], int k) {
        int count = 0;
        int currSum = 0;

        // Map Stores: <PrefixSum,Frequency>
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        prefixSumMap.put(0, 1);
        for (int num : arr) {
            currSum += num;

            // check if there is a prefix sum that matches (currSum-k)
            if (prefixSumMap.containsKey(currSum - k)) {
                count += prefixSumMap.get(currSum - k);
            }


            // record/increment frequency of current prefix sum
            prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }


}
