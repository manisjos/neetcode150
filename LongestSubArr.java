import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArr {
    public static void main(String[] args) {
        System.out.println("Max Length Array Possible: "+maxSubArr(new int[]{2, 1, 5, 1, 3, 2},7));
    }

    private static int maxSubArr(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);  // to handle case when subarray starts from index 0
        int sumSoFar = 0, maxLen = 0;
        for (int i=0;i< nums.length;i++){
            sumSoFar = sumSoFar + nums[i];
            if(map.containsKey(sumSoFar-k)){ // using the same two sum funda
                maxLen = Math.max(maxLen,i- map.get(sumSoFar-k));
            }
            if(!map.containsKey(sumSoFar)){
                map.put(sumSoFar,i);
            }
        }
        return maxLen;
    }
}
