import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
        String s = "abcbcdeaefghih";
        // Second Non-repeating =>
        // f
        s.chars().mapToObj(value -> (char) value).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        char res = 0;
        boolean flag = false;
        char[] charArr = s.toCharArray();
        int arrSet[] = new int[26];
        for (int i = 0; i < charArr.length; i++) {
            arrSet[i] = charArr[i] - 'a';
        }
        for (int i = 0; i < charArr.length; i++) {
            if (arrSet[i] != charArr[i]) {

                res = (char) charArr[i];

            }
        }
        System.out.println(res);
    }
}
