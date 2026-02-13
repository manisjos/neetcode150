import java.util.Arrays;

public class LC88_ {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 0, 0, 0}, m = 3, n = 3, b[] = {2, 5, 6};
        int c[] = {1, 2, 3, 0, 0, 0}, x = 3, y = 3, d[] = {2, 5, 6};
//        int a[] = {4, 5, 6, 0, 0, 0}, m = 3, n = 3, b[] = {1, 2, 3};
        mergeTwoSortedArr(a, m, b, n);
        mergeTwoArr(c, x, d, y);
    }

    static void mergeTwoArr(int a[], int m, int b[], int n) {
        int idx = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] >= b[j]) { // checking
                a[idx--] = a[i--];
            } else {
                a[idx--] = b[j--];
            }
        }

        while (j >= 0) {
            a[idx--] = b[j--];
        }
        System.out.println("Sorted Array now : " + Arrays.toString(a));
    }

    public static void mergeTwoSortedArr(int[] a, int m, int[] b, int n) {
        int idx = m + n - 1,
                i = m - 1,
                j = n - 1;
        // idx such that, we start placing element from
        // the right side of array
        // move towards left by decrementing idx--,i--,j-- counters

        while (i >= 0 && j >= 0) {
            if (a[i] >= b[j]) {
                a[idx--] = a[i--];
            } else {
                a[idx--] = b[j--];
            }
        }
        // the below is to handle when entire
        // right part is sorted and entire left part
        // is pending -->
        // a[] = 4,5,6,0,0,0
        // b[] = 1,2,3
        // after the above code run a[]=4,5,6,4,5,6
        while (j >= 0) {
            a[idx--] = b[j--];
        }
        System.out.println("Sorted Array now : " + Arrays.toString(a));
    }
}
