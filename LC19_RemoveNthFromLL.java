public class LC19_RemoveNthFromLL {

    public static void main(String[] args) {
        ListNode ll = new ListNode(1);
        ll.next = new ListNode(2);
        ll.next.next = new ListNode(3);
        ll.next.next.next = new ListNode(4);
        ll.next.next.next.next = new ListNode(5);
        int n = 2;
        System.out.println("Printing before removing.");
        printList(ll);
        ll = removeNthFromEnd(ll, n);
        System.out.println("After removal. ");
        printList(ll);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " >> ");
            curr = curr.next;
        }
    }
}
