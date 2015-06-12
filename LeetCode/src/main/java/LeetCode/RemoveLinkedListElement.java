package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-12
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */

import common.ListNode;

/**
 *
 * Remove all elements from a linked list of integers that have value val.
 * The key to solve this problem is using a helper node to track the head of the list.
 */
public class RemoveLinkedListElement {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode p = pHead;
        while (p.next != null) {
            if (p.next.val != val) {
                p = p.next;
            } else {
                ListNode temp = p.next;
                p.next = temp.next;
            }
        }
        return pHead.next;
    }
}
