import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {
    public static void main(String[] args) {
        List<Integer> testNums = Arrays.asList(6, 2, 4, 10);
        closestNums(testNums);
    }

    private static void closestNums(List<Integer> nums) {
        Collections.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            int diff = nums.get(i + 1) - nums.get(i);
            if (diff < minDiff) {
                minDiff = diff;
            }

            int n1 = nums.get(i);
            int n2 = nums.get(i+1);

            if((n2-n1)==minDiff){
                System.out.println(n1+ " "+n2);
            }
        }

//        for (int i=0;i<nums.size()-1;i++){
//            int n1 = nums.get(i);
//            int n2 = nums.get(i+1);
//
//            if((n2-n1)==minDiff){
//                System.out.println(n1+ " "+n2);
//            }
//        }

    }
}
