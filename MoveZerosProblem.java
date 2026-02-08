import java.util.Arrays;

public class MoveZerosProblem {
    public static void main(String[] args) {
        int arr[] = {1, 0, 4, 0, 16};
        System.out.println(Arrays.toString(arr) + " input");
        System.out.println("== MoveZeros from Array ==");
        System.out.println(Arrays.toString(moveZerosNaive(arr)) + " updated - Naive");
        System.out.println(Arrays.toString(moveZerosOptimal(arr)) + " updated - In Place");

    }

    public static int[] moveZerosNaive(int arr[]) {
        int l = arr.length;
        int j = 0;
        int newArr[] = new int[l];
        for (int i = 0; i < l; i++) {
            if (arr[i] != 0) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    public static int[] moveZerosOptimal(int arr[]) {
        if (arr == null) return null;
        int l = arr.length;
        int j = 0;
        for (int i = 0; i < l; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }
        while (j < arr.length) {
            arr[j] = 0;
            j++;
        }
        return arr;
    }
}
