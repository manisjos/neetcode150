import java.util.Stack;

public class LC394 {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    private static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // handle multi-digit number
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                //Push the current multiplier and String built so far
                countStack.push(k);
                resStack.push(curr);

                // reset for the content inside the bracket
                curr = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the last String and the repeat count
                StringBuilder tmp = curr;
                curr = resStack.pop();
                int repeatTimes = countStack.pop();
                while (repeatTimes-- > 0) {
                    curr.append(tmp);
                }
            } else {
                // its a regular character, just append
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}
