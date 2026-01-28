import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CyclicRotationCheck {
    public static void main(String[] args) {
        Integer a[] = {1, 2, 3, 4, 5};
        Integer b[] = {3, 4, 5, 1, 4};
        System.out.println("isRotation: " + isRotation(a, b));
    }

    private static boolean isRotation(Integer[] a, Integer[] b) {

        if (a.length != b.length) {
            return false;
        }

        List<Integer> listA = new ArrayList<>(Arrays.asList(a));
        List<Integer> listB = Arrays.asList(b);

        // Concatenate A with itself
        List<Integer> doubledA = new ArrayList<>(listA);
        doubledA.addAll(listA);

        // Check if B is a sublist of doubledA
        return Collections.indexOfSubList(doubledA, listB) != -1;
    }
}
