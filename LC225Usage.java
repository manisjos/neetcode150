public class LC225Usage {
    public static void main(String[] args) {
        LC225_StackUsingQ stack = new LC225_StackUsingQ();

        System.out.println("Pushing: 10 20 30");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Since LIFO, 30 should be on TOP");
        System.out.println("Current TOP: "+stack.top());

        System.out.println("Popped: "+stack.pop());
        System.out.println("Popped: "+stack.pop());

        System.out.println("Is stack empty: "+stack.empty());
        System.out.println("Popped: "+stack.pop());
        System.out.println("Is stack empty now ? : "+stack.empty());
    }
}
