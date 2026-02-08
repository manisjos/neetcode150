import java.util.*;

public class LC215_KthLargetst {

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int K = 2;
        System.out.println(kthLargest(arr, K));

        // largestSubArray with K sum
        int k1 = 3;
        int inputArr[] = {1, 2, 1, 1, 1};

        System.out.println("Input: " + Arrays.toString(inputArr) + " BruteForce: " + Arrays.toString(largestSubArrKSum(k1, inputArr)));

        System.out.println("Input: " + Arrays.toString(inputArr) + " SlidingWindow: " + Arrays.toString(largestSubArrKSumSlidingWindow(k1, inputArr)));
        System.out.println("Input: " + Arrays.toString(inputArr) + " PrefixSum: " + Arrays.toString(largestSubArrKSumPrefixSum(k1, inputArr)));
    }

    private static int[] largestSubArrKSumPrefixSum(int k, int[] arr) {
//        Logic: If the current prefixSum - k has been seen before in the Map,
//        it means the elements between that previous index and the current index sum to $k$.
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0, start = -1, end = -1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = i + 1;
                start = 0;
                end = i;
            }

            // If (sum - k) exists in map, a subarray with sum k exists
            if (map.containsKey(sum - k)) {
                int prevIdx = map.get(sum - k);
                if (i - prevIdx > maxLen) {
                    maxLen = i - prevIdx;
                    start = prevIdx + 1;
                    end = i;
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return (start == -1) ? new int[0] : Arrays.copyOfRange(arr, start, end + 1);
    }

    private static int[] largestSubArrKSumSlidingWindow(int k, int[] arr) {
//        Logic: Move the right pointer to add elements. If the sum exceeds $k$, move the left pointer to reduce the sum.

        int left = 0, right = 0, currSum = 0;

        // tracking best window boundaries
        int bestStart = -1, bestEnd = -1, maxLen = 0;

        while (right < arr.length) {
            currSum += arr[right];

            // shrink window if sum is too large
            while (currSum > k && left <= right) {
                currSum -= arr[left];
                left++;
            }
            if (currSum == k) {
                int currLen = right - left + 1;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    bestEnd = right;
                    bestStart = left;
                }
            }
            right++;
        }
        // Return the slice or an empty array if no sum matches k
        if (bestStart == -1) return new int[0];

        // copyOfRange: from is inclusive, to is exclusive
        return Arrays.copyOfRange(arr, bestStart, bestEnd + 1);
    }

    static int[] largestSubArrKSum(int k, int[] arr) {
//        Logic: Use two nested loops. The outer loop picks a starting point, and the inner loop sums elements until it hits or exceeds $k$
        int maxLen = 0, start = -1, end = -1;
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum == k && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return (start == -1) ? new int[0] : Arrays.copyOfRange(arr, start, end + 1);
    }

    public static int kthLargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // maintaining a mean heap, as we store elements
        for (int val : arr) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
