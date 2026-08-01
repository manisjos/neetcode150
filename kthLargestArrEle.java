import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargestArrEle {
    public static void main(String[] args) {
        int[] arr = {1, 44, 5, 55, 7, 77};
        int k = 2;
        System.out.println("Kth Largest: " + findingKthLargest(arr, k));
        System.out.println("Kth Largest: MinHeap " + findingKthLargestMinHeap(arr, k));
        System.out.println("Kth Largest: MaxHeap " + findKthLargestMaxHeap(arr, k));
    }

    static int findKthLargestMaxHeap(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.offer(num);
        }

        while (k > 1) {
            maxHeap.poll();
            k--;
        }

        return maxHeap.peek();
    }

    static int findingKthLargestMinHeap(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int number : arr) {
            minHeap.offer(number);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    static int findingKthLargest(int arr[], int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }
}
