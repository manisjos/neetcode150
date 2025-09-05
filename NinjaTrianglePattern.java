public class NinjaTrianglePattern {
        public static void printTriangle(int N) {
            int num = 1; // start number

            // Loop through rows
            for (int i = 1; i <= N; i++) {
                // Loop through numbers in each row
                for (int j = 1; j <= i; j++) {
                    System.out.print(num + " ");
                    num++;
                }
                // Move to next line after each row
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int N = 10; // Example input
            printTriangle(N);
        }

}
