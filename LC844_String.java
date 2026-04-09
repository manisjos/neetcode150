import java.util.Stack;

public class LC844_String {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";

        System.out.println(backspaceCompare(s, t));
        System.out.println("Optimal way: ");
        System.out.println(backspaceCompareOptimal2Pointer(s, t));
    }

    private static boolean backspaceCompareOptimal2Pointer(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }


            while (j >= 0) {
                if (s.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }

            // Compare actual characters
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            if ((i >= 0) != (j >= 0)) return false;
            i--; j--;

        }
        return true;
    }

    private static String solveUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private static boolean backspaceCompare(String s, String t) {
//        s.chars()
//                .mapToObj(Character::toString)
//                .reduce("",(str,c)->"#".equals(c)?(str.isEmpty()?"":str.substring(0,str.length()-1)):str.length())


        String sb = solve(s);
        String st = solveUsingStack(t);
        if (sb.equals(st)) return true;
        else return false;
    }

    private static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }
}
