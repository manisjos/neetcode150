import java.util.*;

public class LC18_4SUM {

    public static void main(String[] args) {

        int arr[] = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println("Naive Way: ");
        System.out.println(fourSum(arr, target));

        System.out.println("Optimal Way: ");
        System.out.println(fourSumOptimal(arr, target));
    }

    private static List<List<Integer>> fourSumOptimal(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);


//            🔥 Visual Example
//
//            Array:
//
//            Index:  0  1  2  3  4  5
//            Value: -2 -1  0  0  1  2
//            For i:
//            Max valid i = 2 (value 0)
//            After that → only 3 elements left
//            For j:
//            Max valid j = 3
//            After that → only 2 elements left

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // skip duplicates for i

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));

                        // skip duplicates
                        while (left < right && arr[left] == arr[left + 1]) left++;
                        while (left < right && arr[right] == arr[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> ls = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);

                            // 3. IMPORTANT: Sort the triplet before adding to the Set
                            // This ensures [0, -1, 1] and [-1, 0, 1] are treated as the same
                            Collections.sort(ls);

                            set.add(ls);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
