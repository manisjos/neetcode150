import java.util.LinkedList;
import java.util.Queue;

public class LC225_StackUsingQ {

    private Queue<Integer> queue;

    public LC225_StackUsingQ() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 1. Add the new element to the back of the queue
        queue.add(x);

        // 2. Identify how many elements were already there
        int existingItemsCount = queue.size() - 1;

        // 3. Move all existing items to the back, one by one.
        // This effectively "pushes" the new item to the front.
        while (existingItemsCount > 0) {
            queue.add(queue.remove());
            existingItemsCount--;
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
