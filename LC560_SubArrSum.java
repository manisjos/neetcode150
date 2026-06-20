import java.util.HashMap;
import java.util.Map;

public class LC560_SubArrSum {
    public static void main(String[] args) {
        int arr[] = {9, 4, 20, 3, 10, 5};
        int k = 33;

        System.out.println("Num of SubArr with K Sum: " + numOfSubArr(arr, k));
    }

    static int numOfSubArr(int arr[], int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);

        int currPrefixSum = 0;
        int totalSubarr = 0;

        for (int num : arr) {
            currPrefixSum += num;
            int reqPrefixSum = currPrefixSum - k;
            totalSubarr += prefixSumFreq.getOrDefault(reqPrefixSum, 0);
            prefixSumFreq.put(currPrefixSum, prefixSumFreq.getOrDefault(currPrefixSum, 0) + 1);
        }
        return totalSubarr;
    }
}
