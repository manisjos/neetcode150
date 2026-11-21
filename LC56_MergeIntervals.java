import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC56_MergeIntervals {
    public static void main(String[] args) {
        int intervals[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int intervals2[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};


//        int[][] res = merge(intervals);
//        for (int[] interval : res) {
//            System.out.print("[" + interval[0] + " , " + interval[1] + "] ");
//        }


        int[][] output = mergeIntervalsNew(intervals2);
        for (int[] interval : output) {
            System.out.print("[" + interval[0] + " , " + interval[1] + "] ");
        }
    }

    static int[][] mergeIntervalsNew(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // sort by element 0 of 2d arr
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        // using a List of arrs since we dont know, new possible size of output arr
        List<int[]> output_arr = new ArrayList<>();
        int[] curr_int = intervals[0];
        output_arr.add(curr_int);

        // processing each ints
        for (int[] ivls : intervals) {
            int curr_begin = curr_int[0];
            int curr_end = curr_int[1];

            int next_begin = ivls[0];
            int next_end = ivls[1];

            if (curr_end >= next_begin) {
                curr_int[1] = Math.max(curr_end, next_end);
            } else {
                curr_int = ivls;
                output_arr.add(curr_int);
            }
        }
        return output_arr.toArray(new int[output_arr.size()][]);
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
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        // Step 2: Process each interval
        for (int[] current : intervals) {
            // First interval, or no overlap
            if (result.isEmpty() ||
                    current[0] > result.get(result.size() - 1)[1]) {
                result.add(current);
            } else {
                // Overlap: merge into the last interval
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], current[1]);
            }
        }


        return result.toArray(new int[result.size()][]);
    }

    static int[][] merged1(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

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
