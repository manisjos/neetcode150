public class LC152 {
    public static void main(String[] args) {
        int arr[] = {2, 3, -2, 4};
        System.out.println("Result: " + maxProdSubArr(arr));
    }

    static int maxProdSubArr(int nums[]) {
        if (nums == null || nums.length == 0) return 0;

        // Initialize with first element
        int res = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(n, currMax * n);
            currMin = Math.min(n, currMin * n);
            res = Math.max(res, currMax);
        }
        return res;
    }
}

