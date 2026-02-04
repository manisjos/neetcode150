import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondNonRepChar {
    public static void main(String[] args) {

        String s = "abcbcdeaefghih";
        int k = 2;
        oldWay(s);
        newStreamWay(s, k);
    }

    private static void newStreamWay(String s, int k) {
        char resultChar =
                s.chars().mapToObj(v->(char)v).collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )).entrySet().stream().filter(x->x.getValue()==1)
                                .map(Map.Entry::getKey)
                                        .skip(k-1)
                                                .findFirst()
                                                        .orElse(null);
        System.out.println("Kth Non Repeating char: " + resultChar);
    }

    private static void oldWay(String s) {
    }
}
