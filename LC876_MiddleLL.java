public class LC876_MiddleLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Printing before reversal");
        printList(head);
        ListNode middle = returnMiddleElement(head);
        System.out.println();
        System.out.println("Middle Element: "+middle.val);

    }

    private static ListNode returnMiddleElement(ListNode head) {
        // fast and slow pointer
//        🚀 Optimal Approach (O(n) time, O(1) space)
//        Use two pointers:
//        slow → moves 1 step
//        fast → moves 2 steps
//        When fast reaches the end, slow will be at the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " >> ");
            curr = curr.next;
        }
    }

}
