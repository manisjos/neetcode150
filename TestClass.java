import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        String s = "abcbcdeaefghih";


        // Second Non-repeating =>
        // f
        char streamRes =
        s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(
                Function.identity(), LinkedHashMap::new,Collectors.counting()
        )).entrySet()
                .stream().filter(e->e.getValue()==1).map(Map.Entry::getKey)
                .skip(1).findFirst().orElse(null);

        System.out.println("Stream Result : "+streamRes);


        char res = 0;
        int count = 0;
        char[] charArr = s.toCharArray();
        int arrSet[] = new int[26];
        for (int i = 0; i < charArr.length; i++) {
            arrSet[charArr[i] - 'a']++;
        }
        for (int i = 0; i < charArr.length; i++) {
            if (arrSet[charArr[i] - 'a'] == 1) {
                count++;
                if (count == 2) {
                    res = (char) charArr[i];
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
