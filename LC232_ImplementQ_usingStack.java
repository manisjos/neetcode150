import java.util.Queue;
import java.util.Stack;

public class LC232_ImplementQ_usingStack {
//    inStack  → receives all push() calls
//    outStack → serves all pop() and peek() calls
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public LC232_ImplementQ_usingStack() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Push → always goes to inStack
    public void push(int x) {
        inStack.push(x);
    }

    // Pop - ensure outStack has elements to pop
    public int pop() {
        shiftStacks(); // adjust both instack and outstack
        return outStack.pop();
    }

    public int peek() {
        shiftStacks();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

//    After pushing 1, 2, 3:
//    inStack  →  [1, 2, 3]  (3 is on top)
//    outStack →  []
//    After shiftStacks() is called (e.g. on peek/pop):
//    inStack  →  []
//    outStack →  [3, 2, 1]  (1 is now on top ✅)
//    By pouring inStack into outStack, the order reverses — so the first element pushed (1) ends up on top of outStack, which is exactly what a queue needs (FIFO).

    public static void main(String[] args) {
        LC232_ImplementQ_usingStack q = new LC232_ImplementQ_usingStack();
        q.push(1);
        q.push(2);

        System.out.println("Q peek: "+q.peek());
        System.out.println("Q pop: "+q.pop());
        System.out.println("Q peek: "+q.peek());

        System.out.println("Q isEmpty() ? : "+q.empty());

//        push()  → just dump into inStack, no questions asked
//        peek()  → "wait, I need the oldest element" → shiftStacks() fixes the order
//        pop()   → same, needs oldest element → shiftStacks() fixes the order
    }
}
