import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimiter {

    private final int maxRequests;
    private final long windowSizeMillis;
    private final Map<String, Deque<Long>> userRequests;

    public RateLimiter(int maxRequests, long windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis * 1000;
        this.userRequests = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userRequests.putIfAbsent(userId, new LinkedList<>());
        Deque<Long> timestamps = userRequests.get(userId);

        // Remove old timestamps
        while (!timestamps.isEmpty() && now - timestamps.peekFirst() >= windowSizeMillis) {
            timestamps.pollFirst();
        }
        if (timestamps.size() < maxRequests) {
            timestamps.addLast(now);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(3, 10);
        System.out.println(rateLimiter.allowRequest("user1"));
        System.out.println(rateLimiter.allowRequest("user1"));
        System.out.println(rateLimiter.allowRequest("user1"));
        System.out.println(rateLimiter.allowRequest("user1"));
        Thread.sleep(11_000);
        System.out.println("trying after waking up again!");
        System.out.println(rateLimiter.allowRequest("user1"));
    }
}
