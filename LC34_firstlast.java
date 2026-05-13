import java.util.Arrays;

public class LC34_firstlast {
    public static void main(String[] args) {
        int arr[] = {5, 7, 7, 8, 8, 10};
        int k = 8;
        System.out.println(Arrays.toString(searchRange(arr, k)));
    }

    static int[] searchRange(int[] arr, int k) {
        int firstPos = findFist(arr, k);
        int lastPos = findLast(arr, k);
        return new int[]{firstPos, lastPos};
    }

    static int findLast(int arr[], int k) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == k) {
                answer = mid;
                // keep searching RIGHT
                left = mid + 1;
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    static int findFist(int arr[], int k) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == k) {
                answer = mid;
                // keep searching LEFT
                right = mid - 1;
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
