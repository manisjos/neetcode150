import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParanthesis {
    public static void main(String[] args) {
        String s = "{[()]}";
        String m="))((";
        System.out.println(isValidBruteForce(m));
        System.out.println(isValidStack(m));
        System.out.println(isValidStackHM(m));
        System.out.println(isValidStackHM(m));
    }
    static boolean isValidStackHM(String s){
        Map<Character,Character> map = new HashMap<>();
        // adding ulta references
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!map.containsKey(ch)) { // if its not present in the map

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
