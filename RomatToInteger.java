import java.util.HashMap;
import java.util.Map;

public class RomatToInteger {
    public static void main(String[] args) {
        RomatToInteger romatToInteger = new RomatToInteger();
        System.out.println("MCMXCIV ->" + romatToInteger("MCMXCIV"));
        System.out.println("XL ->" + romatToInteger("XL"));
    }

    public static int romatToInteger(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);


        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currVal = romanMap.get(s.charAt(i));
            // Check if the current value is less than the next value
            // If so, we subtract it (e.g., IV, IX, XL)
            if (i < n - 1 && currVal < romanMap.get(s.charAt(i + 1))) {
                total -= currVal;
            } else {
                total += currVal;
            }
        }
        return total;
    }
}
