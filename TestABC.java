import java.util.Arrays;
import java.util.HashMap;

public class TestABC {
    public static void main(String[] args) {
        int arr1[] = {10, 20, 40, 30, 50};
        int arr2[] = {60, 30, 20, 10, 70, 90};

        // concat arr1 + arr2
        // what are the duplicates
        // second largest element on the concated array
        int n = arr1.length + arr2.length;
        int result[] = new int[n];
        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length+i] = arr2[i];
        }


        System.out.println(Arrays.toString(result));
    }
}
