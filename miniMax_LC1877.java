import java.util.Arrays;

public class miniMax_LC1877 {
    public static void main(String[] args) {
        int arr[] = {4, 1, 5, 1, 2, 5, 1, 5, 5, 4};
        System.out.println(minPairSum(arr));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int maxSum = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pairSum = nums[left] + nums[right];
            maxSum = Math.max(pairSum, maxSum);
            left++;
            right--;
        }
        return maxSum;
    }
}
