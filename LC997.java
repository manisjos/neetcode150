import java.util.Arrays;

public class LC997 {
    public static void main(String[] args) {
        int arr[] = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(squareNSorted(arr)));

//        Idea:
//        Largest square will come from either:
//        Leftmost (most negative)
//        Rightmost (largest positive)
//        Use two pointers:
//        left = 0
//        right = n - 1
//        Fill result array from end to start
    }

    private static int[] squareNSorted(int[] arr) {
        // two pointer
        int n = arr.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            int leftSq = arr[left] * arr[left];
            int rightSq = arr[right] * arr[right];

            // we are doing calculation of squares from both ends of array
            if (leftSq > rightSq) {
                result[pos] = leftSq;
                left++; // so that square calculation is for the next one
            } else {
                result[pos] = rightSq;
                right--;  // so that square calculation is for the prev one
            }
            pos--;
        }
        return result;
    }
}
