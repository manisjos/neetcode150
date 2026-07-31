import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParanthesis {
    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(isValidBruteForce(s));
        System.out.println(isValidStack(s));
        System.out.println(isValidStackHM(s));
    }
    static boolean isValidStackHM(String s){
        Map<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!map.containsKey(ch)) {

                stack.push(ch);

            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.pop() != map.get(ch))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    static boolean isValidStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean isValidBruteForce(String s) {
        while (true) {
            String updated = s.replace("()", "")
                    .replace("[]", "")
                    .replace("{}", "");
            if (updated.equals(s)) {
                break;
            }
            s = updated;
        }
        return s.isEmpty();
    }
}
