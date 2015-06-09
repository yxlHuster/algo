package LeetCode;

/**
 * Created by allen on 6/9/15.
 */

import common.ListNode;

/**
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 *
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode fakeHead1 = new ListNode(-1);
        ListNode fakeHead2 = new ListNode(-1);
        fakeHead1.next = head;

        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;
        while (p != null) {
            if (p.val < x) {
                p = p.next;
                prev = prev.next;
            } else {
                p2.next = p;
                prev.next = p.next;
                p = prev.next;
                p2 = p2.next;
            }
        }
        p2.next = null;
        prev.next = fakeHead2.next;
        return fakeHead1.next;
    }


    public ListNode partition2(ListNode head, int x) {
        if (head == null) return null;
        ListNode fakeHead1 = new ListNode(-1);
        ListNode fakeHead2 = new ListNode(-1);

        ListNode p = head;
        ListNode less = fakeHead1;
        ListNode bigger = fakeHead2;
        while (p != null) {
            if (p.val < x) {
                less.next = p;
                less = less.next;
            } else {
                bigger.next = p;
                bigger = bigger.next;
            }
            p = p.next;
        }
        bigger.next = null;
        less.next = fakeHead2.next;
        return fakeHead1.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(2);
        ListNode third = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(3);
        ListNode six = new ListNode(5);
        head.next = sec;
        sec.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        six.next = null;
        PartitionList p = new PartitionList();
        ListNode result = p.partition2(head, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
