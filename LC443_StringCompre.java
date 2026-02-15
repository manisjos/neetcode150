import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class LC443_StringCompre {
    public static void main(String[] args) {
        char[] arr = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'a', 'a'};
//        return 6 - since a2b2c3
        System.out.println("Result: " + a2B3(arr));
        System.out.println("Result: " + stringCompareRes(arr));
        System.out.println("Result (cleanest and optimal): " + stringCompareGeminiWayNeat(arr));
    }

    private static int stringCompareGeminiWayNeat(char[] arr) {
        //LC
        int n = arr.length;
        int writeIdx = 0; // pointer to write compressed result
        int i = 0; // pointer to traverse the original array
        while (i < n) {
            char currentChar = arr[i];
            int count = 0;

            // 1. Count consecutive occurance
            while (i < n && currentChar == arr[i]) {
                count++;
                i++;
            }

            // 2. Always write the character
            arr[writeIdx++] = currentChar;

            // 3. If count > 1, write the digits of the count
            if (count > 1) {
                // Using String.valueOf is idiomatic and handles multi-digit numbers
                for (char c : String.valueOf(count).toCharArray()) {
                    arr[writeIdx++] = c;
                }

            }
        }
        System.out.println("Array: "+ Arrays.toString(arr));
        return writeIdx;
    }

    private static int stringCompareRes(char[] arr) {
        int n = arr.length, idx = 0, count;
        char ch;
        for (int i = 0; i < n; i++) {
            ch = arr[i];
            count = 0;
            while (i < n && arr[i] == ch) {
                count++;
                i++;
            }
            if (count == 1) {
                arr[idx++] = ch;
            } else {
                String s = Integer.toString(count);
                for (char d : s.toCharArray()) {
                    arr[idx++] = d;
                }
            }
            i--;
        }
        return idx;
    }

    private static int a2B3(char[] arr) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.merge(c, 1, Integer::sum);
        }
        String result =
                map.entrySet().stream()
                        .map(e -> e.getKey().toString() + e.getValue())
                        .collect(Collectors.joining());
        System.out.println(result);

        return result.length();
    }


}
