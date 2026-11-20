import java.util.HashSet;
import java.util.Set;

public class LC2348 {
    public static void main(String[] args) {
        int arr[] = {4, 2, 0, 1, 6};
        System.out.println(ZeroSumSubarrayBruteForce(arr));
        System.out.println(ZeroSumSubarrayOptimal(arr));
    }

    static boolean ZeroSumSubarrayBruteForce(int arr[]) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) { // starting from 0,1,2,3,4...
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean ZeroSumSubarrayOptimal(int arr[]) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        Set<Long> seenPrefixSums = new HashSet<>(arr.length);
        long prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum == 0 || !seenPrefixSums.add(prefixSum)) {
                return true;
            }

//            or below
//            for (int num : nums) {
//                prefixSum += num;
//
//                // 1. Did the running total hit 0?
//                if (prefixSum == 0) {
//                    return true;
//                }
//
//                // 2. Have we seen this exact running total earlier in the array?
//                if (seenPrefixSums.contains(prefixSum)) {
//                    return true;
//                }
//
//                // 3. Otherwise, record this running total so future elements can check against it
//                seenPrefixSums.add(prefixSum);
        }
        return false;
    }


}
