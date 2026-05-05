public class LC416_knapsack {

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        System.out.println("Can Partition ? " + canPartition(arr));
    }

    static boolean canPartition(int arr[]) {
        int totalSum = 0;
        for (int val : arr) {
            totalSum += val;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int targetSumForEachSubset = totalSum / 2;

        boolean[] canFormSum = new boolean[targetSumForEachSubset + 1];

        canFormSum[0] = true;

        for (int currNum : arr) {
            for (int sum = targetSumForEachSubset; sum >= currNum; sum--) {
                boolean canMakeCurrSumWithoutThisNum = canFormSum[sum];
                boolean canMakeRemainingSum = canFormSum[sum - currNum];


                if (canMakeCurrSumWithoutThisNum || canMakeRemainingSum) {
                    canFormSum[sum] = true;
                }
            }
        }
        return canFormSum[targetSumForEachSubset];
    }
}
