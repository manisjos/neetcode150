public class LenOfLastWord {
    public static void main(String[] args) {
        String s = "hey this is last ";
        System.out.println("Length of last word: "+findLenOfLast(s));
    }

    private static int findLenOfLast(String s) {
        int i = s.length()-1;
        int len = 0;

        // skipping trailing space if any
        while (i>=0 && s.charAt(i)==' ')i--;

        // count last word
        while (i>=0&&s.charAt(i)!=' '){
            len++;
            i--;
        }
        return len;
    }
}
