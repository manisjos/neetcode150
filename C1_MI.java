import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1_MI {
    public static void main(String[] args) {
        int arr[][] = {{1, 4}, {2, 9}, {10, 20}};
        System.out.println(Arrays.deepToString(merge(arr)));

        int birr[] = {1, 5, 6, 7, 5, 22};
        int k = 7;
        System.out.println("Index position of K: "+search(birr, k));

    }

    static int[][] merge(int[][] arr) {
        int n = arr.length;
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currInt = arr[0]; // curr interval
        merged.add(currInt); // putting first

        for (int i = 1; i < n; i++) {
            int currEnd = currInt[1];
            int nextStart = arr[i][0];
            int nextEnd = arr[i][1];

            if (nextStart <= currEnd) { // need to merge in this case
                currInt[1] = Math.max(currEnd, nextEnd);
            } else {
                merged.add(arr[i]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    static int search(int nums[], int target) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
