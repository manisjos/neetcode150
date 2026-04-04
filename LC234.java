import java.util.List;

public class LC234 {
    public static void main(String[] args) {
        ListNode LL1 = new ListNode(1);
        LL1.next = new ListNode(2);
        LL1.next.next = new ListNode(2);
        LL1.next.next.next = new ListNode(1);
        System.out.println("Printing List1: ");
        printLL(LL1);

        System.out.println("Is Palindrom: ? -> "+isPalin(LL1));
    }

    static void printLL(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + ">> ");
            curr = curr.next;
        }
    }

    static boolean isPalin(ListNode head) {

        if(head==null||head.next==null) return true;

        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow);

        // Step 3: Compare
        ListNode firstHalf = head;
        ListNode copySecond = secondHalf;

        while (copySecond != null) {
            if (firstHalf.val != copySecond.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            copySecond = copySecond.next;
        }

        // Step 4 (optional): Restore
//        reverse(secondHalf);

        return true;
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
