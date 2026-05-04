import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKOfaQ {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);q.offer(2);q.offer(3);q.offer(4);q.offer(5);
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
        int k = 3;
        System.out.println(reverseFirstK(q, k));
    }

    static Queue<Integer> reverseFirstK(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) {
            return queue;
        }
        Stack<Integer> stack = new Stack<>();

        //  Step1: push K elements on the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step2: Add them back to the queue (reversed)
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Step3: move remaining elements to back
        int remaining = queue.size() - k;
        for (int i = 0; i < remaining; i++) {
            queue.offer(queue.poll());
        }

        return queue;
    }


//    Step 1: Push first K elements into stack
//
//            (queue → stack reverses order)
//
//    Queue: [1,2,3,4,5]
//    Stack: [1,2,3]  (top = 3)
//    Queue left: [4,5]
//    Step 2: Pop stack back into queue
//    Queue: [4,5,3,2,1]
//    Step 3: Move remaining (n - k) elements to back
//    Final Queue: [3,2,1,4,5]
}
