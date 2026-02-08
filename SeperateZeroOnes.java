import java.util.Arrays;

public class SeperateZeroOnes {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int arr2[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int input[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        System.out.println("Naive : " + Arrays.toString(naiveSeperateIt(arr)));
        System.out.println("Optimal : " + Arrays.toString(oneTraversal(arr2)));
        System.out.println("Optimal(Most Efficient) : " + Arrays.toString(oneTraversalME(input)));
    }

    static int[] oneTraversalME(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] == 1) {
                if (arr[high] != 1) {
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                    low++;
                    high--;
                } else {
                    high--;
                }
            } else {
                low++;
            }
        }
        return arr;
    }

    private static int[] oneTraversal(int[] arr) {

//        Maintain two indexes. Initialize the first index left as 0 and second index right as n-1.
//        Do following while lo < hi
//...a) Keep incrementing index lo while there are 0s at it
//...b) Keep decrementing index hi while there are 1s at it
//...c) If lo < hi then exchange arr[lo] and arr[hi]
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            while (arr[lo] == 0 && lo < hi) lo++;
            while (arr[hi] == 1 && lo < hi) hi--;
            if (lo < hi) {
                int temp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = temp;
                lo++;
                hi--;
            }
        }
        return arr;
    }

    static int[] naiveSeperateIt(int arr[]) {
        // two traversal
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            arr[i] = 0;
        }
        for (int i = count; i < arr.length; i++) {
            arr[i] = 1;
        }

        return arr;
    }

}
