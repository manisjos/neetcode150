import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArr {
    public static void main(String[] args) {
        System.out.println("Max Length Array Possible: "+maxSubArr(new int[]{1,2,3},3));
    }

    private static int maxSubArr(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sumSoFar = 0, maxLen = 0;
        for (int i=0;i< nums.length;i++){
            sumSoFar = sumSoFar + nums[i];
            if(map.containsKey(sumSoFar-k)){
                maxLen = Math.max(maxLen,i- map.get(sumSoFar-k));
            }
            if(!map.containsKey(sumSoFar)){
                map.put(sumSoFar,i);
            }
        }
        return maxLen;
    }
}
