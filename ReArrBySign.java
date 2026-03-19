import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReArrBySign {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, -8, -3, -5, -9};
        rearrangeElementsAsPerSign(arr);
        rearrangeElementsAsPerSignOptimal(arr);
    }

    static void rearrangeElementsAsPerSignOptimal(int[] arr) {
        int len = arr.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // 1 Partition the elements
        for (int num : arr) {
            if (num >= 0) pos.add(num);
            else neg.add(num);
        }

        int[] result = new int[len];
        int i = 0, p = 0, n = 0;
        // 2 InterLeave until one list is exhausted
        while (p < pos.size() && n < neg.size()) {
            result[i++] = pos.get(p++);
            result[i++] = neg.get(n++);
        }

        // 3 append remaining pos
        while (p < pos.size()) {
            result[i++] = pos.get(p++);
        }

        // 4 append remaining neg
        while (n < neg.size()) {
            result[i++] = neg.get(n++);
        }

        System.out.println("Optimal Way : " + Arrays.toString(result));
    }

    static void rearrangeElementsAsPerSign(int[] arr) {
        int[] res = new int[arr.length];
        int posIndex = 0;
        int negIndex = 1;

        for (int num : arr) {
            if (num > 0) {
                res[posIndex] = num;
                posIndex += 2;
            } else {
                res[negIndex] = num;
                negIndex += 2;
            }
        }
        System.out.println("Normal way : "+Arrays.toString(res));
    }
}
