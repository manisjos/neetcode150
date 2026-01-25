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

    private static int firstMissingPositiveOptimalV2(int[] nums) {
        int len = nums.length;
        int contains = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int a = Math.abs(nums[i]);
            if (a == len) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return len;
        }
        return len + 1;

    }
}
