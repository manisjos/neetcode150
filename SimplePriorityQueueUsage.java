import java.util.Comparator;
import java.util.PriorityQueue;

public class SimplePriorityQueueUsage {
    public static void main(String[] args) {

//        When you call:
//        offer() → Adds an element.
//        poll() → Removes and returns the smallest element (in min-heap mode) or largest (in max-heap mode, if custom comparator is used).
//        peek() → Just looks at the smallest/largest without removing.

        // Min-heap (default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(5);pq.offer(2);pq.offer(3);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        // Max-heap
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        maxPQ.offer(5);
        maxPQ.offer(1);
        maxPQ.offer(3);
//        System.out.println(maxPQ.peek()); // 5 (largest)
        System.out.println(maxPQ.poll()); // 5 (largest)
        System.out.println(maxPQ.poll()); // 3
        System.out.println(maxPQ.poll()); // 1
    }
}
