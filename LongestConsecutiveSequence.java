import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};
        // naive could be that we sort array and figure out

        // below is optimized O(n) approach or in worse case o(n2)
        System.out.println(longestConsecutive(nums));
    }

    static int longestConsecutive(int arr[]) {
        Set<Integer> set = new HashSet<>();

        // 1. add everything to hashset
        for (int n : arr) {
            set.add(n);
        }

        int longest = 0;

        // 2. check each number
        for (int num : set) {
            // only start if num is the begining
            if (!set.contains(num - 1)) {
                int curr = num;
                int len = 1;


                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }
}
