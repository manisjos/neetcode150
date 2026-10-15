public class MinSubArr1510 {
    public static void main(String[] args) {
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println("Test 1 Result: " + minSubArrayLen(target1, nums1)); // Expected: 2 ([4, 3])

    }

    static int minSubArrayLen(int target, int arr[]) {
        if (arr == null || arr.length == 0 || target <= 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int currWinSum = 0;
        int winStart = 0;

        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            currWinSum += arr[winEnd];

            while (currWinSum >= target) {
                int currWinLen = winEnd - winStart + 1;
                minLen = Math.min(minLen, currWinLen);

                currWinSum -= arr[winStart];
                winStart++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
