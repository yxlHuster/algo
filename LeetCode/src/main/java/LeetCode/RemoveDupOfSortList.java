package LeetCode;

/**
 * Created by author on 6/6/15.
 */

import common.ListNode;

/**
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDupOfSortList {


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            while (next != null) {
                if (next.val != p.val) break;
                next = next.next;
            }
            p = next;
        }
        return head;
    }

}
