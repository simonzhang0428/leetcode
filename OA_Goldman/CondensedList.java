package OA_Goldman;

import java.util.HashSet;
import java.util.Set;

public class CondensedList {
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     *  0   3    4   3   6  null
     *  d   h
     */
    public static ListNode test(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Set<Integer> seen = new HashSet<>();
        
        while (head.next != null) {
            if (seen.contains(head.next.data)) {
                head.next = head.next.next;
            } else {
                seen.add(head.data);
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4, null);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(4, l2);
        ListNode head = new ListNode(3, l1);

        printList(head);
        System.out.println("=============");
        ListNode res = test(head);
        printList(res);
    }
}
