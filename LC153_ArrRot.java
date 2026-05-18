import java.util.Arrays;

public class LC153_ArrRot {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Min Ele: " + findMin(arr));
    }

    static int findMin(int arr[]) {
//        Arrays.sort(arr);
//        return arr[0];

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // mid element > right
            // than minimum element must be on RIGHT
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }

            // right half sorted
            // minimum could be min itself
            else {
                right = mid;
            }
        }
        return arr[left];
    }
}
