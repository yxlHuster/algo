package LeetCode;

import common.ListNode;

/**
 * Created by author on 5/28/15.
 */
public class LinkListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
