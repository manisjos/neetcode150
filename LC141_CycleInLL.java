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

        removeCycle(head2);

        System.out.println("After removal does it have ? ");
        System.out.println(hasCycle(head2));
    }

    private static void removeCycle(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return;

        // Step 2: Find start of cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now both at cycle start

        // Step 3: Find last node of cycle
        while (fast.next != slow) {
            fast = fast.next;
        }

        // Step 4: Break cycle
        fast.next = null;

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
