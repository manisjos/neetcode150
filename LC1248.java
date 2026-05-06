public class LC1248 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 1};
        int k = 3;

        System.out.println("Count: " + numOfSubArr(arr, k));
    }

    static int numOfSubArr(int arr[], int k) {
        return countAtMost(arr, k) - countAtMost(arr, k - 1);
    }

    static int countAtMost(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int oddCount = 0;

        for (int right = 0; right < nums.length; right++) {

            // If current number is odd
            if (nums[right] % 2 != 0) {
                oddCount++;
            }

            // Shrink window if more than k odds
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            // Add number of valid subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }
}
