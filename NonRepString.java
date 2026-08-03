import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepString {
    public static void main(String[] args) {
        String arr[] = {"leeltcode", "lovecoding", "swas", "mast", "ssss"};
        System.out.println("First Non Repeating: ");
        System.out.println(Arrays.toString(firstNonRep(arr)));
        System.out.println("Second Non Repeating: ");
        System.out.println(Arrays.toString(secondNonRep(arr)));
    }

    static char[] firstNonRep(String arr[]) {
        if (arr == null || arr.length == 0) {
            return new char[0];
        }
        char[] result = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = getFirstUnqChar(arr[i]);
        }
        return result;
    }


    static char[] secondNonRep(String arr[]) {
        if (arr == null || arr.length == 0) {
            return new char[0];
        }
        char[] result = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = getSecondUnqChar(arr[i]);
        }
        return result;
    }

    static char getSecondUnqChar(String s) {
        return s.chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )).entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst()
                .orElse('-'); // when you cant find a second non repeating

    }

    static char getFirstUnqChar(String s) {
        int[] freq = new int[26];

        // Pass1: count char freq
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Pass2: Find the first char with a count of 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return '-'; // fallback if all chars repeat
    }
}
