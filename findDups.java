public class findDups {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        int[] nums2 = {3, 1, 3, 4, 2};

        System.out.println("Duplicate in nums1: " + findDuplicate(nums1)); // Output: 2
        System.out.println("Duplicate in nums2: " + findDuplicate(nums2)); // Output: 3
    }

    static int findDuplicate(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }

        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        int p1 = arr[0];
        int p2 = slow;

        while (p1 != p2) {
            p1 = arr[p1];
            p2 = arr[p2];
        }

        return p1;
    }
}
