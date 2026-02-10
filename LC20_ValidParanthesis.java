import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC20_ValidParanthesis {
    public static void main(String[] args) {
        String[] ArrayOfParenthesis = {"(())", "())", "{}", "{{{}}}", "))((", ""};
        for (String Paran : ArrayOfParenthesis) {
            System.out.println("'" + Paran + "' is this valid ? " + isValid(Paran));
            System.out.println("'" + Paran + "' is this valid (using Dequeue) ? " + isValidDequeue(Paran));
        }
//        System.out.println("Are the paranthesis valid ? "+isValid("Saw"));
        System.out.println("Simple Binary Search");
        int[] inputArr = {-1, 0, 3, 5, 9, 12};
        int Target = 9;
        System.out.println("=================================");
        System.out.println("=================================");
        System.out.println("Simple Binary Search ==>" + SimpleBinarySearch(inputArr, Target));
        System.out.println("Recursive Binary Search ==>" + search(inputArr, Target));


    }

    private static boolean isValidDequeue(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static int search(int[] nums, int target) {
        return binarySearchRecursive(nums, target, 0, nums.length - 1);
    }

    public static int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) return binarySearchRecursive(nums, target, mid + 1, right);
        else return binarySearchRecursive(nums, target, left, mid - 1);
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return false;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                // No opening bracket
                if (st.isEmpty())
                    return false;
                char top = st.peek();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
                // Pop matching opening bracket
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static int SimpleBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}