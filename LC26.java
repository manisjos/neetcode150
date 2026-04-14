import java.util.stream.Collectors;

public class LC26 {
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicatesProper(arr));

        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalinCostly(s));
        System.out.println(isPalinAbitOptimal(s));
        System.out.println(isPalinOptimalTwoPtr(s));
    }

    static boolean isPalinOptimalTwoPtr(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {


            // move left pointer forward if current char is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // move right pointer backward if curr char is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalinAbitOptimal(String s) {
//        Time Complexity: $O(n).
//        Space Complexity: $O(n) to store the filtered and reversed strings.

        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) { // ignores comma and space
                builder.append(Character.toLowerCase(ch));
            }
        }

        String filtered = builder.toString();
        String reversed = builder.reverse().toString();
        return filtered.equals(reversed);
    }

    static boolean isPalinCostly(String s) {
        String cleaned = s.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(c -> String.valueOf((char) Character.toLowerCase(c)))
                .collect(Collectors.joining());
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    private static int removeDuplicatesProper(int[] arr) {
        if (arr.length == 0) return 0;
        int left = 0;
        for (int right = 1; right < arr.length; right++) {
            if (arr[right] != arr[left]) { // case when they are actually diff - and we know we have 1 repeated

                left++; // move slow pointer
                arr[left] = arr[right]; // overwrite duplicate - with unique elements
            }
        }
        return left + 1; // number of unique elements
    }

}
