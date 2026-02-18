import java.util.Arrays;

public class RotateKBlocks {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        System.out.println(Arrays.toString(rotateKBlocks(arr, k)));
    }

    private static int[] rotateKBlocks(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];
        int n = arr.length;
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++; right--;

            }
        }
        return arr;
    }
}
