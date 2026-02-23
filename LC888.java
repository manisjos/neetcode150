import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC888 {
    public static void main(String[] args) {
        int aliceSizes[] = {4, 3, 4, 5};
        int bobSizes[] = {4, 3, 1, 6};
        System.out.println("Fair Candy Swap Change: " + Arrays.toString(fairSwap(aliceSizes, bobSizes)))
        ;
    }

    private static int[] fairSwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        for (int x : aliceSizes) sumA += x;
        int sumB = 0;
        Set<Integer> setB = new HashSet<>();
        for (int y : bobSizes) {
            sumB += y;
            setB.add(y);
        }
        int delta = (sumB - sumA) / 2;
        for (int x : aliceSizes) {
            int targetY = x + delta;
            if (setB.contains(targetY)) {
                return new int[]{x, targetY};
            }
        }
        return new int[0];
    }
}
