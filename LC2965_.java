import java.util.Arrays;
import java.util.HashSet;

public class LC2965_ {
    public static void main(String[] args) {
        int grid[][] = {{1, 2}, {2, 3}};
//        findMissingAndRepeatedValues(grid);
        System.out.println("[Missing, Repeated] : " + Arrays.toString(findMissingAndRepeatedValues(grid)));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> hs = new HashSet<>();
        int n = grid.length;
        int expectedSum = 0, actualSum = 0;
        int repeating = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += grid[i][j];
                if (hs.contains(grid[i][j])) {
                    repeating = grid[i][j];
                }
                hs.add(grid[i][j]);
            }
        }
        expectedSum = (n * n) * (n * n + 1) / 2;
        int missingNum = expectedSum + repeating - actualSum;
        return new int[]{repeating, missingNum};
    }
}
