import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NewRateLimiter {

    // userid -> request timestamps
    private Map<String, Queue<Integer>> userReq = new HashMap<>();

    private static final int MAX_REQS = 3;
    private static final int TIME_WIN = 10;

    public boolean allowReq(String userId, int currTime) {
        // get or create queue for user
        userReq.putIfAbsent(userId, new LinkedList<>());
        Queue<Integer> reqTimes = userReq.get(userId);

        // remove expired requests
        while (!reqTimes.isEmpty()
                && currTime - reqTimes.peek() >= TIME_WIN) {
            reqTimes.poll();
        }

        // check if limit is exceeded
        if (reqTimes.size() >= MAX_REQS) {
            return false;
        }

        // add curr req
        reqTimes.offer(currTime);
        return true;
    }

}
