import java.util.Arrays;

public class MaxSlicing {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6, 5, 10, 9};
        System.out.println("Max slices: " + findMaxSlice(arr));
        System.out.println("New Arr: " + Arrays.toString(arr));
    }

    static int findMaxSlice(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        int maxChunks = 0;
        int maxSeenInArr = Integer.MIN_VALUE;
        int maxSeenInSortedArr = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxSeenInArr = Math.max(maxSeenInArr, arr[i]);
            maxSeenInSortedArr = Math.max(maxSeenInSortedArr, sortedArr[i]);

            if (maxSeenInArr == maxSeenInSortedArr) {
                maxChunks++;
            }
        }
        return maxChunks;
    }
}
