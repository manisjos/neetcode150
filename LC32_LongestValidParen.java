import java.util.Stack;

public class LC32_LongestValidParen {
    public static void main(String[] args) {

//        Input: s = ")()())"
//        Output: 4
//        Explanation: The longest valid parentheses substring is "()()".
        System.out.println("Longest valid: " + longestValidParentheses("(()"));
        ;
    }

    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
