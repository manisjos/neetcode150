import java.util.Arrays;

public class LC73 {
    public static void main(String[] args) {

        int matrix[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setMatrixToZero(matrix);
    }

    private static void setMatrixToZero(int[][] matrix) {
        System.out.println("Input: "+Arrays.deepToString(matrix));
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println("Output: ");
        System.out.println(Arrays.deepToString(matrix));
    }


}
