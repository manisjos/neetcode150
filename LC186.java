public class LC186 {
    public static void main(String[] args) {
        Character arr[] = {'t', 'h', 'e', ' ', 's', 'k','y', ' ', 'i','s', ' ', 'b', 'l', 'u', 'e'};
//        System.out.println(reverseWords(arr));
    }

    public static void reverseWords(char[] s) {
        int n = s.length;
        for (int i = 0, j = 0; j < n; ++j) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            } else if (j == n - 1) {
                reverse(s, i, j);
            }
        }
        reverse(s, 0, n - 1);
    }

    private static void reverse(char[] s, int i, int j) {
        for (; i < j; ++i, --j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
