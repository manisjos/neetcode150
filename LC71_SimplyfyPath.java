import java.util.Stack;

public class LC71_SimplyfyPath {
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println("Simplified -> " + simplyfy(path));
    }

    static String simplyfy(String path) {
        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");
        for (String currPart : parts) {
            if (currPart.equals("") || currPart.equals(".")) {
                continue;
            } else if (currPart.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(currPart);
            }
        }
        // building again
        StringBuilder sim = new StringBuilder();
        for (String dir : stack) {
            sim.append("/");
            sim.append(dir);
        }

        if (sim.length() == 0) {
            return "/";
        }
        return sim.toString();
    }
}
