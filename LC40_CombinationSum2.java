import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_CombinationSum2 {
    public static void main(String[] args) {
        // backtracking and recursion
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates); // ⭐ important for duplicate handling

        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start,
                                  List<Integer> curr, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // ⭐ Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // ⭐ Prune (since sorted)
            if (candidates[i] > target) {
                break;
            }

            // Choose
            curr.add(candidates[i]);

            // ❗ Move forward (i + 1 → no reuse)
            backtrack(candidates, target - candidates[i], i + 1, curr, result);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
}
