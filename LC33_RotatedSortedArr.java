public class LC33_RotatedSortedArr {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 0, 1, 2, 3};
        System.out.println("The index of element in the Array : " + findIndexNaive(arr, 0));
        System.out.println("The index of element in the Array : " + findIndexPro(arr, 0));
    }

    private static int findIndexPro(int arr[], int key) {
        int n = arr.length;
        int pivot = findPivot(arr, 0, n - 1);

        if (pivot == key)
            return pivot;

        if (pivot == 0)
            return binarySearch(arr, 0, n - 1, key);

        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    private static int findPivot(int[] arr, int low, int high) {
        while (low <= high) {
            if (arr[low] <= arr[high]) {
                return low;
            }
            int mid = (low + high) / 2;
            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }


    public static int findIndexNaive(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return i + 1;
        }
        return -1;
    }

}
