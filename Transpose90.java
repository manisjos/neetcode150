import java.util.Arrays;

public class Transpose90 {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Original:");
        printMatrix(mat);
        rotate90_CounterClockWise(mat);
        System.out.println("Step 1: Rotated 90° CounterClock wise");
        printMatrix(mat);
        System.out.println("Step 2: Rotated 90° Clockwise: back to how it looked");
        rotate90_ClockWise(mat);
    }

    private static void rotate90_ClockWise(int[][] mat) {
        int n = mat.length;
        // Step 1: Transpose the matrix
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                // Swap matrix[i][j] with matrix[j][i]
                // 1,2,3
                int temp = mat[i][j]; // mat[0][1] : 2 assigning 2 to 'temp'
                mat[i][j] = mat[j][i]; // mat[1][0] is: 4 and assigning mat[0][1] as 4
                mat[j][i] = temp; // mat[0][1] assigning 2 stored in temp
                // so properly swapping 1 element at a time
            }
        }
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverseRow(mat[i],n-1);
        }
        printMatrix(mat);
    }

    private static void reverseRow(int[] row,int n) {
        int left=0, right=n;
        while (left<right){
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    static void rotate90_CounterClockWise(int mat[][]){
       int n = mat.length;
        // Reverse each row
        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start < end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }

        // Performing Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
