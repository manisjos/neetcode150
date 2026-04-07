import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomInsta {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Xabi",
                "Ramos",
                "Jis",
                "Swas",
                "Kris",
                " ",
                null,
                "mans",
                ""
        );
        List<String> filteredNames =
                names.stream()
                        .filter(Objects::nonNull) // ignores the nulls
                        .filter(x -> !x.isBlank())
//                .filter(x->!x.isEmpty())
                        .collect(Collectors.toList());
        System.out.println(filteredNames);
        int arr[] = {14, 5, 63, 3, 2, 44};
        findLargestSecondLargest(arr);

        List<Integer> l1 = Arrays.asList(1,2,3,4,5);
        List<Integer> l2 = Arrays.asList(4,5,6,7,8);
        removeDuplicatesAndMerge(l1,l2);
    }

    private static void removeDuplicatesAndMerge(List<Integer> l1, List<Integer> l2) {
        List<Integer> result =
        Stream.concat(l1.stream(),l2.stream()).distinct().toList();
        System.out.println("fixed -> "+result);

        String s = "Good Morning";
        Optional<String> len = Stream.of(s.split(" "))
                .max(Comparator.comparingInt(String::length));
        System.out.println(len.get()); // printing the word with highest length
    }

    private static void findLargestSecondLargest(int[] arr) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i]>secondLargest && arr[i]!=largest){
                secondLargest = arr[i];
            }
        }

        System.out.println("Largest : "+largest+", SecondLargest: "+secondLargest);
    }
}
