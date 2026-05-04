import java.util.ArrayList;
import java.util.List;

public class LC78_Subset_Backtracking {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(subset(arr));
    }

    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add a copy of current subset
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < arr.length; i++) {
            // Choose
            currentSubset.add(arr[i]);

            // Explore
            backtrack(arr, i + 1, currentSubset, result);

            // Undo (backtrack)
            currentSubset.remove(currentSubset.size() - 1);
        }
// Execution Tree for {1, 2, 3}
//        backtrack(start=0, current=[])
// ✔ save []
// ├── add 1 → backtrack(start=1, current=[1])
// │    ✔ save [1]
// │    ├── add 2 → backtrack(start=2, current=[1,2])
// │    │    ✔ save [1,2]
// │    │    └── add 3 → backtrack(start=3, current=[1,2,3])
// │    │         ✔ save [1,2,3]  ← loop ends, no more elements
// │    │         remove 3
// │    │    remove 2
// │    └── add 3 → backtrack(start=3, current=[1,3])
// │         ✔ save [1,3]
// │         remove 3
// │    remove 1
// ├── add 2 → backtrack(start=2, current=[2])
// │    ✔ save [2]
// │    └── add 3 → backtrack(start=3, current=[2,3])
// │         ✔ save [2,3]
// │         remove 3
// │    remove 2
// └── add 3 → backtrack(start=3, current=[3])
//      ✔ save [3]
//        remove 3
    }
}
