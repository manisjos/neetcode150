import java.util.ArrayList;
import java.util.Arrays;

public class SplitArrIn {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int N = nums.length;
        int K = 4;

        ArrayList<ArrayList<Integer>> ans = divideArr(nums, K, N);
        printArr(ans);
    }

    static void printArr(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < a.get(i).size(); j++) {
                System.out.print(a.get(i).get(j) + " ");
            }
            System.out.print(" ]");
        }
    }

    private static ArrayList<ArrayList<Integer>> divideArr(int[] nums, int k, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            temp.add(nums[i]);
            if (((i + 1) % k) == 0) {
                ans.add(temp);
                temp = new ArrayList<Integer>();
            }
        }

        // if last group doesnt have enough elements then add 0 to it
        if (temp.size() != 0) {
            int a = temp.size();
            while (a != k) {
                temp.add(0);
                a++;
            }
            ans.add(temp);
        }
        return ans;
    }
}
