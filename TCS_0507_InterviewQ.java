import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class TCS_0507_InterviewQ {
    public static void main(String[] args) {
        // concat arr1 + arr2
        // what are the duplicates
        // second largest element on the concated array


        int arr1[] = {10, 20, 40, 30, 50};
        int arr2[] = {60, 30, 20, 10, 70, 90};

        System.out.println("Concatenated Normal way: " + concatenated(arr1, arr2));
        System.out.println("Concatenated Index way: " + concatenatedIndexWay(arr1, arr2));
        System.out.println("Concatenated HashSet way (removing duplicates): " + concatenatedHashSetWay(arr1, arr2));
    }

    static String concatenatedHashSetWay(int[] arr1, int[] arr2) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            set.add(num);
        }
        return set.toString();
    }

    static String concatenated(int arr1[], int arr2[]) {
        int result[] = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }

        return Arrays.toString(result);
    }

    static String concatenatedIndexWay(int arr1[], int arr2[]) {
        int result[] = new int[arr1.length + arr2.length];
        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            result[index++] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[index++] = arr2[i];
        }

        System.out.println("Finding the Second Highest value: " + secondHighest(result));
        System.out.println("Finding the Second Highest value - stream way: " + secondHighestStream(result));

        return Arrays.toString(result);
    }
    static int secondHighestStream(int arr[]){
        return Arrays.stream(arr).distinct()
                .boxed()
                .sorted((a,b)->b-a)
                .skip(1)
                .findFirst()
                .orElseThrow();

    }

    static int secondHighest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secLargest = largest;
                largest = num;
            } else if (num > secLargest && num != largest) {
                secLargest = num;
            }
        }
        System.out.println("Largest = " + largest);
        System.out.println("Second Largest = " + secLargest);
        return secLargest;
    }
}
