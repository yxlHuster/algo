package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-5-31
 * Time: 下午6:47
 * To change this template use File | Settings | File Templates.
 */

import common.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            p1 = p1.next;
        } else {
            head = l2;
            p2 = l2.next;
        }
        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2.next = p2;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode p = newHead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;
        return newHead.next;
    }

}
