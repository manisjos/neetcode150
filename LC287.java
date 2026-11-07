public class LC287 {
    public static void main(String[] args) {
        int arr[] = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(arr));
        System.out.println(findDuplicateFloydCycle(arr));
    }

    static int findDuplicateFloydCycle(int arr[]) {
        // Step 1: Initialize slow and fast pointers
        int slow = arr[0];
        int fast = arr[0];

        // Step 2: Find the intersection point of the two pointers in the cycle
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);


        // Step 3: Find the entrance to the cycle (the duplicate number)
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    static int findDuplicate(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Count elements less than or equal to mid
            int count = 0;
            for (int n : arr) {
                if (n <= mid) {
                    count++;
                }
            }

            // According to Pigeonhole Principle, if count > mid,
            // the duplicate lies in the lower range [low, mid]

            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
