import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackTwoStack {
    private final Deque<Integer> valStack;
    private final Deque<Integer> minStack;

    public MinStackTwoStack() {
        valStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    // why did we had to declare such constructor

    public void push(int val) {
        valStack.push(val);
        // push to minStack if empty or if val is <=current minimum
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (valStack.isEmpty()) return;
        if (valStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        valStack.pop();
    }

    public int top() {
        return valStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStackTwoStack minStack = new MinStackTwoStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("minStack.getMin() >>"+minStack.getMin());

        minStack.pop();
        System.out.println("minStack.top() >>"+minStack.top());
        System.out.println("minStack.getMin() >>"+minStack.getMin());
    }
}
