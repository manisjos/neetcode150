import java.util.*;

public class LC15_3SUM {
    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, -4};
        int arr1[] = {-1, 0, 1, 2, -1, -4};
        System.out.println("3 Sum: " + threeSum(arr));
        System.out.println("3 Sum: " + threeSumOptimalWay(arr1));
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> ls = Arrays.asList(arr[i], arr[j], arr[k]);

                        // 3. IMPORTANT: Sort the triplet before adding to the Set
                        // This ensures [0, -1, 1] and [-1, 0, 1] are treated as the same
                        Collections.sort(ls);

                        set.add(ls);
                    }
                }
            }
        }
        return new ArrayList<>(set);

    }

    public static List<List<Integer>> threeSumOptimalWay(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[left] + arr[right] + arr[i];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    result.add(triplet);
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
