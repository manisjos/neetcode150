import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LC56_MergeIntervals {
    public static void main(String[] args) {
        int intervals[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};


        int[][] res = mergeIntervals(intervals);
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
}
