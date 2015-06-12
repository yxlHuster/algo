package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-12
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */

import common.ListNode;

/**
 * http://www.programcreek.com/2014/04/leetcode-swap-nodes-in-pairs-java/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example, given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = newHead;

        while (p.next != null && p.next.next != null) {
            ListNode first = p;
            p = p.next;
            first.next = p.next;

            ListNode second = p.next.next;
            p.next.next = p;
            p.next = second;
        }
        return newHead.next;

    }


}
