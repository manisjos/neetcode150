import java.util.Stack;

public class LC20_ValidParanthesis {
    public static void main(String[] args) {
        String[] ArrayOfParenthesis = {"(())", "())", "{}", "{{{}}}", ""};
        for (String Paran : ArrayOfParenthesis) {
            System.out.println("'" + Paran + "' is this valid ? " + isValid(Paran));
        }
//        System.out.println("Are the paranthesis valid ? "+isValid("Saw"));
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
}