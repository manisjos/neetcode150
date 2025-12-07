public class LC268_MissingNum {

        public static int missingNumber(int[] nums) {
            int n = nums.length;
            int res = n * (n + 1) / 2;
            int existingSum = 0;
            for (int i = 0; i < n; i++) {
                existingSum = nums[i] + existingSum;
            }
            return existingSum - res;
        }

    public static void main(String[] args) {
        System.out.println("Missing number in Array: "+missingNumber(new int[]{1,3,4}));
    }
}
