import java.util.Arrays;

public class RotateKArrs {
    public static void main(String[] args) {
        int arr[] = {1, 0, 4, 0, 16};

        System.out.println(Arrays.toString(arr) + " input");
        System.out.println("== rotate K elements from Array ==");
        int k = 2;
        rotateKNaive(arr, k);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Updated - In Place");
        rotateKOpti(arr, k);
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    private static void rotateKOpti(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < k) {
                // Place last k elements at the beginning
                res[i] = arr[n + i - k];
            } else {
                // Shift the rest
                res[i] = arr[i - k];
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = res[i];
        }
    }

    private static void rotateKNaive(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return;
        }
        int l = arr.length;
        // rotate right by one position
        int temp = arr[l - 1];
        for (int i = l - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        rotateKNaive(arr, k - 1);
        // 16,1,0,4,0 - Step1
        // 0,16,1,0,4 - Step2 - make recursive call for the same method
    }
}
