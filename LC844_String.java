public class LC844_String {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";

        System.out.println(backspaceCompare(s, t));
    }

    private static boolean backspaceCompare(String s, String t) {
//        s.chars()
//                .mapToObj(Character::toString)
//                .reduce("",(str,c)->"#".equals(c)?(str.isEmpty()?"":str.substring(0,str.length()-1)):str.length())


        String sb = solve(s);
        String st = solve(t);
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
