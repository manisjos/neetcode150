import java.util.PriorityQueue;

public class kthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Element-> "+findKthLargest(nums, k));
    }

    static int findKthLargest(int arr[], int k) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>(k);

        for (int num:arr){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
