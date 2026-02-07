import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC151 {
    public static void main(String[] args) {
//        String s = "the sky is blue";
        String s  = "a good   example";
        reverseIndividuallyUsingArr(s);
        reverseIndividuallyUsingList(s);
        pureStreamWay(s);
    }

    private static void pureStreamWay(String s) {
        System.out.println("Stream way:");
        System.out.println(
        Arrays.stream(s.trim().split("\\s+"))
                .reduce((word1,word2)->word2+ " "+ word1)
                .orElse("")
        );
    }

    private static void reverseIndividuallyUsingList(String s) {
        // 1. Split into list of words,
        //  ignoring extra spaces
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        // 2. Reverse the list
        Collections.reverse(words);
        // 3. Join them back with Single space
        System.out.println("Reversed Using List: ");
        System.out.println(words.stream().collect(Collectors.joining(" ")));

        // o / p - Reversed: example   good a

    }

    static void reverseIndividuallyUsingArr(String s) {
        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        for (int i = n-1; i >= 0; i--){
            sb.append(arr[i]+" ");
        }
        System.out.println("Reversed: "+sb.toString().trim());

    }
}
