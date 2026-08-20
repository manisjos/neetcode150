import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MI6 {
    // merge interval
    public static void main(String[] args) {
        int intervals[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    static int[][] merge(int arr[][]) {
        int n = arr.length;
        if (arr == null || n < 1) {
            return arr;
        }

        // Sort since, via that we'd be sure once we
        // compare one of the interval - there wont be surprises
        // Sort intervals by start time in ascending order
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>(); // creating 1D arr list
        int[] currInt = arr[0]; // extracting first element
        merged.add(currInt); // adding that first in the newly created list, since we gonna loop from 1 so added the 0th

        for (int i = 1; i < n; i++) {
            int currEnd = currInt[1];
            int nextStart = arr[i][0];
            int nextEnd = arr[i][1];

            if (nextStart <= currEnd) {
                currInt[1] = Math.max(currEnd, nextEnd);
            } else {
                currInt = arr[i];
                merged.add(currInt);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
