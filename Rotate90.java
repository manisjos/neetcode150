import java.util.Arrays;

public class Rotate90 {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Before rotate "+Arrays.deepToString(mat));
        rotate90(mat);

    }

    static void rotate90(int mat[][]){
        int n = mat.length;
        int res[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[j][n-i-1] = mat[i][j];
            }
        }
        System.out.println("After rotate ");
        System.out.println(Arrays.deepToString(res));
    }
}
