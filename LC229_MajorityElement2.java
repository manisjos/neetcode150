import java.util.ArrayList;
import java.util.List;

public class LC229_MajorityElement2 {
    public static void main(String[] args) {
        int arr[] = {3, 2, 3};
        System.out.println("Maj Elements: " + findMajElements(arr));
    }

    static List<Integer> findMajElements(int nums[]) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        // Step1 : voting phase
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // Step2: Verification Phase
        count1 = 0;
        count2 = 0;
        for (int n1 : nums) {
            if (n1 == candidate1) count1++;
            else if (n1 == candidate2) count2++;
        }
        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);
        return result;
    }
}
