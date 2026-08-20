import java.util.PriorityQueue;

public class KthLargestInArrWithoutSorting {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(kthLarg(arr, k));
    }

    static int kthLarg(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
