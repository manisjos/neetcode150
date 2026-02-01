import java.util.HashMap;
import java.util.Map;

public class MaxSumKSubArr {
    public static void main(String[] args) {
        int arr[] = {1, 5, 4, 2, 9, 9, 9};
//        int arr[] = {4, 4, 4};
        int k = 6;
        maxSumKSubArr(arr, k);
        maximumSubarraySum(arr, k);
        maximumSubarrayDistinctSum(arr, k);
        printCountOfSubArrWhoSumAreK(arr, k);
    }

    static void printCountOfSubArrWhoSumAreK(int arr[], int k) {
        int count = 0, sumSoFar = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // to add the single entry, that will be fetched for first match in  line 21
        for (int i = 0; i < arr.length; i++) {
            sumSoFar += arr[i];
            if (map.containsKey(sumSoFar - k)) {
                count += map.get(sumSoFar - k);
            }
            map.put(sumSoFar, map.getOrDefault(sumSoFar, 0) + 1);
        }
        System.out.println("Printing Count Of Sub Arr Whos Sum Are K : "+count);
    }

    private static void maximumSubarrayDistinctSum(int[] arr, int k) {
        int n = arr.length;
        if (n < k) System.out.println("0");
        long maxSum = 0, currSum = 0;
        // Map <Element,Freq>
        Map<Integer, Integer> countsMap = new HashMap<>();
        // 1. process the first window
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
            countsMap.put(arr[i], countsMap.getOrDefault(arr[i], 0) + 1);
        }
        // check if first window is valid
        if (countsMap.size() == k) {
            maxSum = currSum;
        }

        // 2. Slide the window through the rest of the array
        for (int i = k; i < n; i++) {
            // add the incoming element
            int incoming = arr[i];
            currSum += incoming;
            countsMap.put(incoming, countsMap.getOrDefault(incoming, 0) + 1);

            // remove the outgoing element
            int outgoing = arr[i - k];
            currSum -= outgoing;

            if (countsMap.get(outgoing) == 1) {
                countsMap.remove(outgoing);
            } else {
                countsMap.put(outgoing, countsMap.get(outgoing) - 1);
            }

            if (countsMap.size() == k) {
                maxSum = Math.max(maxSum, currSum);
            }

        }
        System.out.println("Max Distinct Sum: " + maxSum);

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
        System.out.println("Max: " + maxSum);
    }
}
