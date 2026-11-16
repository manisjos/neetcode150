public class LC33 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Index of 0: " + search(nums, 0)); // Output: 4
        System.out.println("Index of 3: " + search(nums, 3)); // Output: -1
    }

    static int search(int arr[], int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            // Step 1: Determine if the left half [low...mid] is strictly sorted
            if (arr[low] <= arr[mid]) {
                // Step 2a: Check if target falls inside this sorted left range
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Otherwise, the right half [mid...high] must be strictly sorted
            else {
                // Step 2b: Check if target falls inside this sorted right range
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
