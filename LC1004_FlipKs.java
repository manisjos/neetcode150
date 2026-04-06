public class LC1004_FlipKs {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println("Max 1s -> " + longestOnes(arr, k));
    }

    private static int longestOnes(int[] arr, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeroCount++;
            }

//            while (window is invalid) {
//                remove left element
//                left++
//            }
            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
