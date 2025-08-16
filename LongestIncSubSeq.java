import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LongestIncSubSeq {
    public static void main(String[] args) {
//        int[] arr = {12, 3, 5, 7, 19};
        int[] arr = {4,10,4,3,8,9};
        System.out.println("Approach 1: my way - fails in some cases ");
        System.out.println(LongestSubSeq(arr));
        System.out.println("Approach 2: dynamic programming O(n2)");
        System.out.println(lengthOfLIS(arr));
        System.out.println("Approach 3: Binary Search O(n log n)");
        System.out.println(lengthOfLIS_BinarySearch(arr));
    }

    private static int lengthOfLIS_BinarySearch(int[] arr) {
        List<Integer> tails = new ArrayList<>();
        for (int num:arr){
            int idx = Collections.binarySearch(tails,num);
            if(idx<0) idx= -(idx+1);
            if(idx == tails.size()){
                tails.add(num);
            } else {
                tails.set(idx,num);
            }
        }
        return tails.size();
    }

    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int maxLen=1;

        Arrays.fill(dp,1);
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

    private static int LongestSubSeq(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                count++;
            } else {
                // do nothing
            }
        }
        return count + 1;
    }
}
