import java.util.ArrayList;
import java.util.List;

public class SubsetsIterative {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> subsets(int arr[]) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());// starting with empty set[]
        for (int num : arr) {
            int n = result.size();
            for (int i = 0; i < n; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }
        return result;
    }
}
