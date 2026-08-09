import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int[] num1 = {3, 2, 1, 5, 6, 4};
        int[] num2 = {1,4,7,8};
        System.out.println("Element-> "+findKthLargest(nums, k));
        merge(nums, 5,num2,3);
    }


        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int i = m + n - 1;

            // Compare elements from the back and place the larger element at index i
            while (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] > nums2[p2]) {
                    nums1[i] = nums1[p1];
                    p1--;
                } else {
                    nums1[i] = nums2[p2];
                    p2--;
                }
                i--;
            }

            // Copy remaining elements from nums2, if any
            while (p2 >= 0) {
                nums1[i] = nums2[p2];
                p2--;
                i--;
            }
//            System.out.println(Arrays.toString(num));
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
