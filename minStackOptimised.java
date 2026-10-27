import java.util.ArrayDeque;
import java.util.Deque;

public class minStackOptimised {
    private final Deque<Long> stack = new ArrayDeque<>(16);
    private long minVal;

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long) val);
            minVal = val;
        } else if (val < minVal) {
            stack.push(2L * val - minVal);
            minVal = val;
        } else {
            stack.push((long) val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long top = stack.pop();

        // if (top<minVal), its a transformed value being placed on stack
        if (top < minVal) {
            minVal = 2 * minVal - top; // hence reverting it to earlier minVal, finding earlier minVal using this formula
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < minVal) {
            return (int) minVal;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        return (int) minVal;
    }

    public static void main(String[] args) {
        minStackOptimised minStack = new minStackOptimised();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-4);

        System.out.println("minStack.getMin() >>" + minStack.getMin());

        minStack.pop();
        System.out.println("minStack.top() >>" + minStack.top());
        System.out.println("minStack.getMin() >>" + minStack.getMin());
    }
}
