import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class firstMissingNumber_LC41 {

    public static int firstMissingPositiveHMApproach(int[] nums) {

        // Step 1: Create HashMap
//        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        // Step 2: Store frequency of each number
        for (int num : nums) {
            set.add(num);
        }

        int n = nums.length;

        // Step 3: Check from 1 to n+1
        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
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
