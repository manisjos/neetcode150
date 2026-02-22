import java.util.Arrays;

public class LC452_BaloonsBurst {
    public static void main(String[] args) {
        int points[][] = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Number of Arrows needed: " + findMinArrowShots(points));
    }

    private static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> Integer.compare(x[0], y[0]));
        int arrows = 1;
        int prevStart = points[0][0];
        int prevEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];
            if (currStart > prevEnd) {
                arrows++;
                prevStart = currStart;
                prevEnd = currEnd;
            } else {
                prevStart = Math.max(currStart, prevStart);
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }
        return arrows;
    }
}
