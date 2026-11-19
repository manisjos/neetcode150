import java.util.PriorityQueue;

public class CapGPossible {
    public static void main(String[] args) {
        int arr[] = {4,5,66,74,43};
        int k=2;

        System.out.println(findKthLargest(arr,k));
    }
    static int findKthLargest(int arr[],int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num:arr){
            minHeap.offer(num);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
