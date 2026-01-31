public class MaxSumKSubArr {
    public static void main(String[] args) {
//        int arr[] = {2, 1, 5, 1, 3, 2};
        int arr[] = {4, 4, 4};
        int k = 3;
        maxSumKSubArr(arr, k);
        maximumSubarraySum(arr,k);
        maximumSubarrayDistinctSum(arr,k);
    }

    private static void maximumSubarrayDistinctSum(int[] arr, int k) {

    }
    private static void maxSumKSubArr(int[] arr, int k) {
        int n = arr.length, currSum = 0, maxSum = Integer.MIN_VALUE;
        if (n > 3) {
            for (int i = 0; i <= k; i++) {
                currSum += arr[i];
                maxSum = Math.max(currSum, maxSum);
                if (currSum < 0) {
                    currSum = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println("Max " + maxSum);
    }


    public static void maximumSubarraySum(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int n = arr.length;
        // first window - sum
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum; // in case the k is 3 only

        // next window onwards
        for (int i = k; i < n; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println("Max: "+maxSum);
    }
}
