import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int arr[] = {5, 8, 12, 1, 7};
        int arr1[] = {5, 8, 12, 1, 7};
        System.out.println(Arrays.toString(boobaSort(arr)));
        System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println("Simple Bubble: " + Arrays.toString(simpleBubbleSort(arr)));
        System.out.println("Merge Bubble: " + Arrays.toString(mergeSort(arr1)));
    }

    private static int[] mergeSort(int[] arr) {
        mergeSortCustom(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSortCustom(int[] arr, int left, int right) {
        if (left >= right) return; // base case : 1 element
        int mid = left + (right - left) / 2; // avoids int overflow vs (l+r) / 2
        mergeSortCustom(arr, left, mid);
        mergeSortCustom(arr, mid + 1, right);
        actualMerge(arr, left, mid, right);
    }

    private static void actualMerge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right)
            tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= right) tmp[k++] = arr[j++];

        System.arraycopy(tmp, 0, arr, left, tmp.length);
    }

    private static int[] simpleBubbleSort(int[] arr) {
        // Compare every adjacent pair and bubble the max to the end
        // Bubble Sort · O(n²) time, O(1) space
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] insertionSort(int[] arr) {
        // Insertion Sort · O(n²) worst, O(n) best, O(1) space
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
        return arr;
    }

    private static int[] boobaSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }
}
