import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC888 {
    public static void main(String[] args) {
        int aliceSizes[] = {4, 3, 4, 5};
        int bobSizes[] = {4, 3, 1, 6};
        System.out.println("Fair Candy Swap Change: HashSet Approach > " + Arrays.toString(fairSwap(aliceSizes, bobSizes)));
        System.out.println("Fair Candy Swap Change: Two pointer Approach > " + Arrays.toString(fairSwap2Pt(aliceSizes, bobSizes)));
    }

    private static int[] fairSwap2Pt(int[] aliceSizes, int[] bobSizes) {
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        int sumA = Arrays.stream(aliceSizes).sum();
        int sumB = Arrays.stream(bobSizes).sum();
        int delta = (sumB - sumA) / 2;
        int i = 0, j = 0;
        while (i < aliceSizes.length && j < bobSizes.length) {
            int currDiff = bobSizes[j] - aliceSizes[i];
            if (currDiff == delta) {
                return new int[]{aliceSizes[i], bobSizes[j]};
            } else if (currDiff < delta) {
                j++;  // need a larger value from bob
            } else {
                i++; // need a smaller value from alice
            }
        }
        return new int[0];
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
