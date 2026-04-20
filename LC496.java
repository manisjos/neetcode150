import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC496 {
    public static void main(String[] args) {
        int arr1[] = {2,4};
        int arr2[] = {1,2,3,4};

        System.out.println("NGE-> " + Arrays.toString(nextGreaterElement(arr1, arr2)));
    }

    private static int[] nextGreaterElement(int[] arr1, int[] arr2) {
        // map to store the next greater element for each number in arr2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : arr2) {
            // while the current element is greater then stack's top
            // the current number is the NGE for the stack's top element
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // preparing result
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            // if its not in the map, means no NGE was found
            result[i] = nextGreaterMap.getOrDefault(arr1[i],-1);
        }
        return result;
    }
}
