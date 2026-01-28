import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1200_minDiff {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int arr2[] = {1,3,6,10,15};
        int arr3[] = {3,8,-10,23,19,-4,-14,27};

        System.out.println(minDiff(arr));
        System.out.println(minDiff(arr2));
        System.out.println(minDiff(arr3));
    }

    private static List<List<Integer>> minDiff(int[] arr) {
        // sort tha array
        Arrays.sort(arr);

        // assume 1st pair is ideal
        int minDiff = arr[1] - arr[0];

        // get minDiff possible from array
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < minDiff) {
                minDiff = arr[i + 1] - arr[i];
            }
        }

        // list and collect those elements
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                ans.add(List.of(arr[i], arr[i + 1]));
            }
        }

        return ans;
    }


}
