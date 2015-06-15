package LeetCode;

import common.ListNode;

/**
 * Created by author on 5/28/15.
 */
public class LinkListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }


    /**
     * 寻找环的起点
     * @param node
     * @return
     */
    public ListNode findCircleNode(ListNode node) {
        if (node == null) return null;
        if (node.next == null) return null;
        ListNode slow = node;
        ListNode fast = node;
        boolean hasCircle = false;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCircle = true;
                break;
            }
        }
        if (!hasCircle) return null;
        fast = node;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }



}
