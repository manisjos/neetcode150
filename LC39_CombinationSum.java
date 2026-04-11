import java.util.ArrayList;
import java.util.List;

public class LC39_CombinationSum {
    public static void main(String[] args) {
        // backtracking and recursion
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combSum(candidates, target);
        System.out.println(result);
    }

    private static List<List<Integer>> combSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]); // 👉 It adds the current number into your ongoing combination (curr).
            backtrack(candidates, target - candidates[i], i, curr, result); // It recursively explores further combinations by reducing the target with the chosen value while allowing reuse of the same element
            curr.remove(curr.size() - 1); // It removes the last chosen element to restore the state before the recursive call, allowing us to explore other combinations without interference.
        }
    }
}
