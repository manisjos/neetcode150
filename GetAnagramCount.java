import java.util.Arrays;
import java.util.List;

public class GetAnagramCount {
    public static void main(String[] args) {
        String ana = "123122";
        System.out.println("Number of Change needed: " + getAna(ana));
    }

    private static int getAna(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }
        int mid = s.length() / 2;
        String s1 = s.substring(0, mid);
        String s2 = s.substring(mid);

        int[] charCount = new int[10];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - '0']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            charCount[s2.charAt(i) - '0']--;
        }

        int ops = 0;
        for (int count : charCount) {
            if (count > 0) {
                ops += count;
            }
        }
        return ops;
    }


}
