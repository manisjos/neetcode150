public final class StringGame {

    public static void main(String[] args) {

        section("1. STRING POOL & REFERENCES");
        stringPoolDemo();

        section("2. IMMUTABILITY PROOF");
        immutabilityDemo();

        section("3. INTERN()");
        internDemo();

        section("4. HASHCODE CACHING");
        hashCodeDemo();

        section("5. CONCATENATION BEHAVIOR");
        concatenationDemo();

        section("6. STRING vs STRINGBUILDER (MEMORY)");
        stringBuilderDemo();
    }

    // ------------------------------------------------------------

    private static void stringPoolDemo() {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");

        System.out.println("s1 == s2 : " + (s1 == s2)); // true (same pool reference)
        System.out.println("s1 == s3 : " + (s1 == s3)); // false (heap object)
        System.out.println("s1.equals(s3) : " + s1.equals(s3)); // true (value comparison)
    }

    // ------------------------------------------------------------

    private static void immutabilityDemo() {
        String original = "hello";
        String modified = original.concat(" world");

        System.out.println("Original: " + original);  // hello
        System.out.println("Modified: " + modified);  // hello world

        // proves original was not changed
    }

    // ------------------------------------------------------------

    private static void internDemo() {
        String s1 = "java";
        String s3 = new String("java");

        String s4 = s3.intern();

        System.out.println("s1 == s4 : " + (s1 == s4)); // true
    }

    // ------------------------------------------------------------

    private static void hashCodeDemo() {
        String s = "performance";

        int h1 = s.hashCode();
        int h2 = s.hashCode();

        System.out.println("Hash 1: " + h1);
        System.out.println("Hash 2 (cached): " + h2);
        System.out.println("Same hash reused (cached internally)");
    }

    // ------------------------------------------------------------

    private static void concatenationDemo() {

        String a = "a" + "b"; // compile-time optimization
        System.out.println("Compile-time concat: " + a);

        String x = "a";
        String y = "b";
        String runtime = x + y; // uses StringBuilder internally

        System.out.println("Runtime concat: " + runtime);
    }

    // ------------------------------------------------------------

    private static void stringBuilderDemo() {

        String s = "";
        for (int i = 0; i < 5; i++) {
            s = s + i; // creates new object every iteration
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(i); // same object reused
        }

        System.out.println("String result: " + s);
        System.out.println("StringBuilder result: " + sb);
    }

    // ------------------------------------------------------------

    private static void section(String title) {
        System.out.println("\n===============================");
        System.out.println(title);
        System.out.println("===============================");
    }
}