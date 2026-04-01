public class LC21 {
    public static void main(String[] args) {

        ListNode LL1 = new ListNode(1);
        LL1.next = new ListNode(3);
        LL1.next.next = new ListNode(5);
        System.out.println("Printing List1: ");
        printLL(LL1);

        ListNode LL2 = new ListNode(2);
        LL2.next = new ListNode(4);
        LL2.next.next = new ListNode(6);
        System.out.println();
        System.out.println("Printing List2: ");
        printLL(LL2);
        System.out.println();
        System.out.println("-----------------------");
        printLL(mergeLL(LL1, LL2));



    }

    private static ListNode mergeLL(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // temporary starter
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next; // the most recently added node after dummy - a kind of pointer to it
        }
        // attaching the remaining nodes
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        return dummy.next;
    }

    static void printLL(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " >> ");
            curr = curr.next;
        }
    }
}
