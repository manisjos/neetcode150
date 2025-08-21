import java.util.PriorityQueue;

public class LC215_KthLargetst {

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int K = 2;
        System.out.println(kthLargest(arr, K));
    }
    public static int kthLargest(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // maintaining a mean heap, as we store elements
        for (int val:arr){
            pq.add(val);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
