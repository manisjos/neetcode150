import java.util.concurrent.CompletableFuture;

public class OddEven_CF {
    public static void main(String[] args) {
        runCompletableFutureApproach();
    }

    private static final int MAX = 10;

    static void runCompletableFutureApproach() {
        CompletableFuture<Void> future = CompletableFuture.completedFuture(null);
        for (int i = 1; i <= MAX; i++) {
            final int number = i;
            if (number % 2 != 0) {
                future = future.thenRunAsync(() ->
                        System.out.println("Odd Thread -> " + number));
            } else {
                future = future.thenRunAsync(() ->
                        System.out.println("Even Thread -> " + number));
            }
        }
        future.join();
    }
}
