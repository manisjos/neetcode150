import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrHash {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Single Threaded....");
        Map<String, Integer> stock = new ConcurrentHashMap<>();
        stock.put("Laptop", 15);
        stock.put("Phone", 0);
        stock.put("Tablet", 5);
        stock.put("Monitor", 0);

        for (Map.Entry<String, Integer> en : stock.entrySet()) {
            if (en.getValue() == 0) {
                stock.remove(en.getKey());
            } else {
                stock.put(en.getKey() + "-Discounted", en.getValue());
            }
        }


        ConcurrentHashMap<String, Integer> pageViews = new ConcurrentHashMap<>();
        pageViews.put("home", 0);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                pageViews.compute("home", (key, curr) -> (curr == null) ? 1 : curr + 1);
            });
        }

        executorService.shutdown();
        System.out.println("triggered");
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("triggered ends");
        System.out.println("Final Page Views for 'home': " + pageViews.get("home")); // Guaranteed 1000
    }
}
