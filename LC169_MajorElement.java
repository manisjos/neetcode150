import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC169_MajorElement {
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};
        int nums1[] = {3, 3, 4};
        System.out.println("Major Element: " + majorityElement(nums));
        System.out.println("Major Element: " + majorityElementEfficient(nums1));
        majorityElement1(nums);
    }

    public static int majorityElementEfficient(int[] nums) {
        int cand = 0, freq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (freq == 0) {// when candidate is new
                freq = nums[i];
            }
            if (freq == nums[i]) {// when candidate is repeating, hence we add up
                freq++;
            } else {
                freq--;
            }
        }
        return freq;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int res = 0, maxCount = 0;
        for (int n : nums) {
            int freq = countMap.getOrDefault(n, 0) + 1;
            countMap.put(n, freq);
            if (freq > maxCount) {
                res = n;
                maxCount = freq;
            }
        }
        return res;
    }

    public static void majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int freq = 1, majorElement = nums[0], n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == majorElement) {
                freq++;
            } else {
                freq = 1;
                majorElement = nums[i];
            }
        }
        System.out.println("v1 Majority : " + majorElement);
    }
}
