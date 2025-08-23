import java.lang.reflect.Array;
import java.util.Arrays;

public class LC167_TwoSum_V2 {
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15}, target = 9;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }
    private static int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] > target) {
                right--;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }
}
