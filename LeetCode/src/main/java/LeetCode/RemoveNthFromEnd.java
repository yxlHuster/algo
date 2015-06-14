package LeetCode;

import common.ListNode;

/**
 * Created by allen on 6/12/15.
 */
public class RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        ListNode node = r.removeNthFromEnd(head, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
