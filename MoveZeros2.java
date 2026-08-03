import java.util.Arrays;

public class MoveZeros2 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 4, 12};
        System.out.println(Arrays.toString(postMoveZeros(nums)));
        System.out.println(Arrays.toString(postMoveZerosSinglePass(nums)));
    }

    static int[] postMoveZerosSinglePass(int[] arr) {
        int lastNonZeroFountAt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // swap non-zero ele with the ele at lastNonZeroFoundAt
                int tmp = arr[lastNonZeroFountAt];
                arr[lastNonZeroFountAt] = arr[i];
                arr[i] = tmp;
                lastNonZeroFountAt++;
            }
        }
        return arr;
    }

    static int[] postMoveZeros(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[lastNonZeroFoundAt++] = arr[i];
            }
        }

        while (lastNonZeroFoundAt < arr.length) {
            arr[lastNonZeroFoundAt++] = 0;
        }
        return arr;
    }
}
