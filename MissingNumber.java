import java.util.Arrays;
import java.util.HashMap;

public class MissingNumber {
    public static void main(String[] args) {

        int arr[] = {3,4,-1,1};
//        int arr1[] = {3,4,-1,1};
//        int arr2[] = {7,8,9,11,12};
        int listOfArr[][] = {arr};


        int[] nums1 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums1));
        System.out.println(firstMissingPositiveOptimal(nums1));
    }

    static int firstMissingPositiveOptimal(int[] nums) {
//        int n = nums.length;
//        for (int i=0;i<n;i++){
//
//        }
        return 1;
    }

    public static int firstMissingPositive(int[] nums) {


        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int m=nums.length;
        for (int i=0;i<m+1;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return -1;
    }

}
