import java.util.Arrays;

public class LC14_LongestComnPrefix {
    public static void main(String[] args) {
        String[] s = {"flight", "flower", "fl"};
        System.out.println(longestCommonPrefix(s));
    }

    static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
    }
}
