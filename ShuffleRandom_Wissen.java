import java.util.Arrays;
import java.util.Random;

public class ShuffleRandom_Wissen {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        randomize(arr, n);
    }

    private static void randomize(int[] arr, int n) {
        Random r = new Random();
        // Start from the last element and swap one by one. We dont need to run for the first element that why i>0
        for (int i = n - 1; i > 0; i--) {

            // pick a random index from 0 to i
            int j = r.nextInt(i + 1);

            // swapping it with arr[i]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
