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

    static int firstMissingPositiveOptimal(int[] nums) {
        // each number x should be at x-1 index
        // for eg number 1 should be at 0 index
        // for eg number 2 should be at 1 index
        // for eg number 3 should be at 2 index
        // for eg number 4 should be at 3 index
        // for eg number 5 should be at 4 index
        // After rearranging - the ideal order
//        Index: 0 1 2 3
//        Value: 1 2 3 4
//        If this is true → answer = n+1.
//        If not → first mismatch is answer.

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // checking if the number is in 1 to n+1 range only, then checking
                // if the number is at expected place
                // if (NOT) then the below swap happens
                swap(nums, i, nums[i] - 1);
            }
        }

//        below is checking
//        Index 0 → should be 1
//        Index 1 → should be 2
//        Index 2 → should be 3
//        First mismatch = missing.

        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // For testing
    public static void main(String[] args) {

        int[] nums1 = {3, 4, -1, 1};
        System.out.println(firstMissingPositiveHMApproach(nums1)); // 2

        int[] nums2 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositiveHMApproach(nums2)); // 1

        int[] nums3 = {1, 2, 0};
        System.out.println(firstMissingPositiveHMApproach(nums3)); // 3
        System.out.println("== Via Optimal Approach ==");
        System.out.println(firstMissingPositiveOptimal(nums1)); // 2
        System.out.println(firstMissingPositiveOptimal(nums2)); // 1
        System.out.println(firstMissingPositiveOptimal(nums3)); // 3
        System.out.println("== Via Optimal Approach v2 ==");
        System.out.println(firstMissingPositiveOptimalV2(nums1)); // 2
        System.out.println(firstMissingPositiveOptimalV2(nums2)); // 1
        System.out.println(firstMissingPositiveOptimalV2(nums3)); // 3
    }

    static int firstMissingPositiveOptimalV2(int[] nums) {

        int len = nums.length;

        // ----------------------------------------------------
        // STEP 1: Check if number 1 exists in the array
        // ----------------------------------------------------
        // Because the smallest missing positive must be >= 1.
        // If 1 is not present, we can immediately return 1.
        int contains = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                contains = 1;
                break;
            }
        }

        if (contains == 0) {
            return 1;
        }

        // ----------------------------------------------------
        // STEP 2: Clean the array
        // ----------------------------------------------------
        // Replace all numbers that are:
        //   <= 0 (negative / zero)
        //   > len (out of useful range)
        // with 1.
        //
        // After this step, every element is in range [1, len].
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }

        // ----------------------------------------------------
        // STEP 3: Mark presence using index as hash
        // ----------------------------------------------------
        // We use array indices to record which numbers exist.
        //
        // For each value "a":
        //   - Mark index "a" as negative (means: a is present)
        //   - Special case: if a == len, mark index 0
        //
        // We use Math.abs() because values may already be negative.
        for (int i = 0; i < len; i++) {

            int a = Math.abs(nums[i]);

            // If value equals array length,
            // mark index 0 (special handling)
            if (a == len) {
                nums[0] = -Math.abs(nums[0]);
            }
            // Otherwise mark index = a
            else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        // ----------------------------------------------------
        // STEP 4: Find first positive index
        // ----------------------------------------------------
        // If nums[i] is still positive,
        // it means number "i" was never seen.
        //
        // So i is the missing number.
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        // ----------------------------------------------------
        // STEP 5: Check for number = len
        // ----------------------------------------------------
        // If index 0 is positive,
        // then number "len" is missing.
        if (nums[0] > 0) {
            return len;
        }

        // ----------------------------------------------------
        // STEP 6: All numbers 1..len are present
        // ----------------------------------------------------
        // So answer is len + 1.
        return len + 1;
    }
}
