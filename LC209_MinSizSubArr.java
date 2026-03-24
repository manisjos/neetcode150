public class LC209_MinSizSubArr {
    public static void main(String[] args) {
        int target = 7;
        int nums[] = {2, 3, 1, 2, 4, 3};
        System.out.println("Min Size SubArr: " + minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
