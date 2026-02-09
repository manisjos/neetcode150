import java.util.HashSet;
import java.util.Set;

public class longestConsecLen {
    public static void main(String[] args) {

        int arr[] = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of Longest Consecutive Streak: " + longestConsecutive(arr));
    }

    private static int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int longestStreak = 0;

        for (int numToCheck : set) {
            if (!set.contains(numToCheck - 1)) {
                int currNum = numToCheck;
                int currStreak = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }
}
