import java.util.Arrays;
import java.util.stream.Collectors;

public class StringManipulation {
    public static void main(String[] args) {

        String s = "this is Sam";
//       "siht si mas";
        System.out.println("Input String : " + s);
        System.out.println("In place reversal : " + inPlaceStringReversal(s));
        System.out.println("JDK Stream way : " + usingStreams(s));
        System.out.println("Without libraries way : " + withoutLibs(s));
    }

    private static String withoutLibs(String s) {
        String[] words = s.split(" ");
        String result = "";
        for (String word : words) {
            char[] chars = word.toCharArray();
            int left = 0, right = chars.length - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            result += new String(chars) + " ";
        }
        return result;
    }

    private static String usingStreams(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    private static String inPlaceStringReversal(String s) {
        String arr[] = s.split(" ");
        StringBuilder resultSB = new StringBuilder();
        for (String word : arr) {
            String reverserdWord = new StringBuilder(word).reverse().toString();
            resultSB.append(reverserdWord).append(" ");
        }
        return resultSB.toString().trim();
    }
}
