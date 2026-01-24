import java.util.HashMap;
import java.util.Map;

public class firstMissingNumber_LC41 {

    public static int firstMissingPositiveHMApproach(int[] nums) {

        // Step 1: Create HashMap
        Map<Integer, Integer> map = new HashMap<>();

        // Step 2: Store frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;

        // Step 3: Check from 1 to n+1
        for (int i = 1; i <= n + 1; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }

        return -1; // never reached
    }

    // For testing
    public static void main(String[] args) {

        int[] nums1 = {3, 4, -1, 1};
        System.out.println(firstMissingPositiveHMApproach(nums1)); // 2

        int[] nums2 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositiveHMApproach(nums2)); // 1

        int[] nums3 = {1, 2, 0};
        System.out.println(firstMissingPositiveHMApproach(nums3)); // 3
    }
}
