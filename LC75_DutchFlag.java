import java.util.Arrays;

public class LC75_DutchFlag {
    public static void main(String[] args) {
        int arr1[] = {2, 0, 2, 1, 1, 0};
        int arr[] = {2, 0, 2, 1, 1, 0};
//        dutchFlagNaive(arr1);
        dutchFlagGood(arr);
    }

    private static void dutchFlagGood(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap mid with low and move both forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is in the right place (middle), just move mid forward
                mid++;
            } else { // nums[mid] == 2
                // Swap mid with high and move high backward
                // Don't increment mid yet; we need to check the swapped value
                swap(nums, mid, high);
                high--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    private static void dutchFlagNaive(int[] nums) {
//        int right = nums.length;
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i] != i && nums[right-1] == i) {
//                int temp = nums[i];
//                nums[i] = nums[right];
//                nums[right] = temp;
//            }
//        }
//    }
}
