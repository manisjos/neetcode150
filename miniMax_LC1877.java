import java.util.*;

public class miniMax_LC1877 {
    public static void main(String[] args) {
        int arr[] = {4, 1, 5, 1, 2, 5, 1, 5, 5, 4};
        System.out.println(minPairSum(arr));


        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> map1 = new LinkedHashMap<>();
        Map<String,Integer> map2 = new TreeMap<>();


        map.put("Swasti",1);    map.put(null,22);map.put(null,23);    map.put("Jishant",12);   map.put("Krishvi",7);
        map1.put("Swasti",1);     map1.put(null,1);    map1.put("Jishant",12);   map1.put("Krishvi",7);
           map2.put("Swasti",1);        map2.put("Jishant",12);   map2.put("Krishvi",7);

        System.out.println("map: "+map);
        System.out.println("map: "+map1);
        System.out.println("map: "+map2);
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int maxSum = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pairSum = nums[left] + nums[right];
            maxSum = Math.max(pairSum, maxSum);
            left++;
            right--;
        }
        return maxSum;
    }
}
