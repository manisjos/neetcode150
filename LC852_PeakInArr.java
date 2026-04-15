public class LC852_PeakInArr {
    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 7, 6, 4, 2};
        System.out.println("Index : " + peakIndexInMountains(arr));
    }

    private static int peakIndexInMountains(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // go right
                left = mid + 1;
            } else {
                // go left
                right = mid;
            }
        }
        return left;
    }
}
