public class LC141_CycleInLL {
    public static void main(String[] args) {
        // No cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        System.out.println("Does this LL has a Cycle 1 ? ");
        System.out.println(hasCycle(head1)); // false

        ListNode head2 = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        head2.next = second;
        second.next = third;
        third.next = second;
        System.out.println("Does this LL has a Cycle 2 ? ");
        System.out.println(hasCycle(head2));

    }

    static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
