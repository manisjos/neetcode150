import java.util.Arrays;

public class findDupls {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 3, 2};
        System.out.println("Naive and Costly way: " + naiveAndCostlyWay(arr));
        System.out.println("Best Solution: " + findDupFloydAlgo(arr));
    }

    private static int findDupFloydAlgo(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        fast = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    static int naiveAndCostlyWay(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }
}
