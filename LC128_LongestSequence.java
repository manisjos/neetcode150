import java.util.HashSet;
import java.util.Set;

public class LC128_LongestSequence {
    public static void main(String[] args) {
        int arr[] = {100, 4, 200, 1, 3, 2};
        System.out.println("The longest streak in current array is "+longestConsecutive(arr)+".");
    }

    static int longestConsecutive(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : numSet) {
            // Only attempt to build a sequence if 'num' is the START of a sequence
            if (!numSet.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;

                // count forward to find the length of this consecutive sequence
                while (numSet.contains(currNum + 1)) {
                    currNum += 1;
                    currStreak += 1;
                }
                longestStreak = Math.max(currStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}
