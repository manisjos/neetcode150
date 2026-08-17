import java.util.*;

public class QueueFunda {
    public static void main(String[] args) {

        Deque<Integer> deque= new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        System.out.println("ArrayDeque Remove First: " + deque.pollFirst()); // 5
        System.out.println("ArrayDeque Remove Last: "  + deque.pollLast());  // 20

        System.out.println();
        Queue<Integer> fifoQueue = new ArrayDeque<>();
        fifoQueue.offer(30);
        fifoQueue.offer(10);
        fifoQueue.offer(20);

        System.out.println("FIFO Queue Poll: " + fifoQueue.poll());


        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);

        System.out.println("Min-Heap Root (Min): " + minHeap.peek());
        System.out.println("Min-Heap Poll: "        + minHeap.poll());
        System.out.println("Min-Heap Poll: " + minHeap.poll());
        // Max-PriorityQueue using custom Comparator
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);

        System.out.println("Max-Heap Root (Max): " + maxHeap.peek());
        System.out.println("Max-Heap Poll: "        + maxHeap.poll());
        System.out.println("Max-Heap Poll: " + maxHeap.poll());
    }
}
