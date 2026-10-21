public class MaxNumAfterDigRemoval {
    public static void main(String[] args) {
        System.out.println(removeDigs("15456", '5'));
        System.out.println(removeDigs("54521", '5'));
    }

    static String removeDigs(String number, char digit) {
        int lastSeenIndexOfDigit = -1;
        int n = number.length();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                lastSeenIndexOfDigit = i;
                if (i + 1 < n && number.charAt(i + 1) > digit) {
                    // If the next character is strictly greater, remove this digit immediately
                    return number.substring(0, i) + number.substring(i + 1);
                }
            }
        }
        // if no digits, was formed by a larger one, remove the last occurance
        return number.substring(0, lastSeenIndexOfDigit) + number.substring(lastSeenIndexOfDigit + 1);
    }
}
