import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StringInternalsDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1. IMMUTABILITY & MEMORY REFERENCE ===");
        demonstrateImmutability();

        System.out.println("\n=== 2. LOOP PERFORMANCE (100,000 APPEND OPERATIONS) ===");
        demonstratePerformance();

        System.out.println("\n=== 3. CONCURRENCY & THREAD SAFETY ===");
        demonstrateConcurrency();
    }

    // -------------------------------------------------------------------------
    // 1. IMMUTABILITY: Does modifying the value create a new object on the Heap?
    // -------------------------------------------------------------------------
    private static void demonstrateImmutability() {
        String str = "JPMC";
        int strBeforeHash = System.identityHashCode(str);
        str += " Payments"; // Allocates a brand new String object
        int strAfterHash = System.identityHashCode(str);

        StringBuilder sb = new StringBuilder("JPMC");
        int sbBeforeHash = System.identityHashCode(sb);
        sb.append(" Payments"); // Mutates internal byte[] in place
        int sbAfterHash = System.identityHashCode(sb);

        System.out.println("String identity changed?        " + (strBeforeHash != strAfterHash)); // true
        System.out.println("StringBuilder identity changed? " + (sbBeforeHash != sbAfterHash));   // false
    }

    // -------------------------------------------------------------------------
    // 2. PERFORMANCE: String O(N^2) vs StringBuilder/StringBuffer O(N)
    // -------------------------------------------------------------------------
    private static void demonstratePerformance() {
        int iterations = 100_000;

        // A. String concatenation in a loop (Creates 100,000 intermediate objects)
        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < iterations; i++) {
            s += "a";
        }
        long stringTimeMs = (System.nanoTime() - start) / 1_000_000;

        // B. StringBuilder (Unsynchronized mutable byte[] array)
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder(iterations); // Pre-sizing avoids array resizing
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long builderTimeMs = (System.nanoTime() - start) / 1_000_000;

        // C. StringBuffer (Synchronized mutable byte[] array)
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer(iterations);
        for (int i = 0; i < iterations; i++) {
            sbf.append("a");
        }
        long bufferTimeMs = (System.nanoTime() - start) / 1_000_000;

        System.out.println("String (+=) time:       " + stringTimeMs + " ms");
        System.out.println("StringBuilder time:     " + builderTimeMs + " ms");
        System.out.println("StringBuffer time:      " + bufferTimeMs + " ms");
    }

    // -------------------------------------------------------------------------
    // 3. THREAD SAFETY: What happens when 10 threads append 1,000 chars each?
    // Expected final length = 10,000
    // -------------------------------------------------------------------------
    private static void demonstrateConcurrency() throws InterruptedException {
        int threads = 10;
        int appendsPerThread = 1_000;

        StringBuilder unsafeBuilder = new StringBuilder();
        StringBuffer safeBuffer = new StringBuffer();

        ExecutorService executor = Executors.newFixedThreadPool(threads);
        CountDownLatch latch = new CountDownLatch(threads);

        for (int t = 0; t < threads; t++) {
            executor.submit(() -> {
                try {
                    for (int i = 0; i < appendsPerThread; i++) {
                        unsafeBuilder.append("x"); // Race condition on internal 'count' index
                        safeBuffer.append("x");    // Synchronized method locks intrinsic monitor
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        executor.shutdown();

        System.out.println("Expected length:              " + (threads * appendsPerThread));
        System.out.println("StringBuilder actual length:  " + unsafeBuilder.length() + " (Data lost or ArrayIndexOutOfBounds!)");
        System.out.println("StringBuffer actual length:   " + safeBuffer.length() + " (100% consistent)");
    }
}