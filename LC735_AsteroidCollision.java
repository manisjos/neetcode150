import java.util.Arrays;
import java.util.Stack;

public class LC735_AsteroidCollision {
    public static void main(String[] args) {
        int arr[] = {3, 5, -6, 2, -1, 4};
        System.out.println(Arrays.toString(asteroidCollisioin(arr)));
    }

    static int[] asteroidCollisioin(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int currAst : arr) {
            boolean currAstDestroyed = false;

            // Collision possible only if:
            // stack top moving right
            // current moving left

            while (!stack.isEmpty() && stack.peek() > 0 && currAst < 0) {
                int topAst = stack.peek();

                // case 1
                // Top ast, smaller -> destroy it
                if (Math.abs(topAst) < Math.abs(currAst)) {
                    stack.pop();
                }

                // case 2
                // both are same size -> both destroyed
                else if (Math.abs(topAst) == Math.abs(currAst)) {
                    stack.pop();
                    currAstDestroyed = true;
                    break;
                }

                // case 3
                // curr ast is smaller -> curr destroyed
                else {
                    currAstDestroyed = true;
                    break;
                }
            }
            if (!currAstDestroyed) {
                stack.push(currAst);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
