import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC56_MergeIntervals {
    public static void main(String[] args) {
        int intervals[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};


        int[][] res = merge(intervals);
        for (int[] interval : res) {
            System.out.print("[" + interval[0] + " , " + interval[1] + "] ");
        }
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> ans = new LinkedList<>();

        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // sorting by start time
        Arrays.sort(intervals, (a, b) ->
                Integer.compare(a[0], b[0]));

        int[][] merged = new int[intervals.length][2];
        int size = 0;

        for (int[] current : intervals) {
            if (size == 0 ||
                    current[0] > merged[size - 1][1]) {

                merged[size++] = current;
            } else {
                merged[size - 1][1] =
                        Math.max(merged[size - 1][1], current[1]);
            }
        }
        return Arrays.copyOf(merged, size);
    }
}
