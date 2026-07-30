import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecNonRepChar {
    public static void main(String[] args) {
        String s="abcbcdeaefghih";
        System.out.println(secNonRep(s));
    }

    static char secNonRep(String s){
        return s.chars().mapToObj(x->(char)x)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1).map(Map.Entry::getKey)
                .skip(1)
                .findFirst()
                .orElse(null);
    }
}
