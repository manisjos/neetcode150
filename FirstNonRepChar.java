public class FirstNonRepChar {
    public static void main(String[] args) {
        String input = "swiss";
        System.out.println("Array Approach: " + findFirstNonArr(input));
    }

    static Character findFirstNonArr(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }
}
