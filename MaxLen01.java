public class MaxLen01 {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 1, 1};
        System.out.println("Count bruteforce way : "  +findMaxLength(arr));
    }
    static int findMaxLength(int[] nums) {
    // bruteforce
        int maxLength = 0;

        for (int start = 0; start < nums.length; start++) {

            int zeros = 0;
            int ones = 0;

            for (int end = start; end < nums.length; end++) {

                if (nums[end] == 0)
                    zeros++;
                else
                    ones++;

                if (zeros == ones) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }
        }

        return maxLength;
    }

}
