import java.util.HashMap;
import java.util.Map;

public class LC169_MajorElement{
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};
        int nums1[] = {3,3,4};
        System.out.println("Major Element: " + majorityElement(nums));
        System.out.println("Major Element: " + majorityElementEfficient(nums1));
    }

    public static int majorityElementEfficient(int[] nums) {
        int cand = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {// when candidate is new
                cand = nums[i];
            }
            if (cand == nums[i]) {// when candidate is repeating, hence we add up
                count++;
            } else {
                count--;
            }
        }
        return cand;
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
}
