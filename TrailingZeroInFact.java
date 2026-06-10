public class TrailingZeroInFact {
    public static void main(String[] args) {
        int[] testcases = {5, 10, 25, 100, 1000};
        for (int n : testcases) {
            System.out.printf("Trailing zeros in %d -> %d%n", n, trailingZeros(n));
        }
    }


//    Example: n = 100
//            ⌊
//            5
//            100
//            ​
//
//            ⌋=20
//            ⌊
//            25
//            100
//            ​
//
//            ⌋=4
//            ⌊
//            125
//            100
//            ​
//
//            ⌋=0
//
//    Total:
//
//            20+4=24
//
//    So 100! has 24 trailing zeros.
    static int trailingZeros(int n) {
        int count = 0;
        // Iteratively divide n by powers of 5 and aggregate the quotients
        while (n >= 5) {
            count += n / 5;
            n /= 5; // Simulates moving to the next power of 5 (5, 25, 125...)
        }
        return count;
    }
}
