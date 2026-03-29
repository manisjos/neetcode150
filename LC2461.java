import java.util.HashSet;
import java.util.Set;

public class LC2461 {
    public static void main(String[] args) {
        int nums[] = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        maximumSubArr(nums, k);
    }

    private static void maximumSubArr(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        int left = 0;
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            // If the element is already in the set, it's a duplicate.
            // Shrink the window from the left until the duplicate is removed.
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // Add the current element to the window
            set.add(nums[right]);
            currentSum += nums[right];

            // If the window size exceeds k, remove the leftmost element
            if (right - left + 1 > k) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // If the window is exactly size k, update the maxSum
            // (Uniqueness is guaranteed by the while loop above)
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        System.out.println("Maximum Sum: "+maxSum);
    }
}
