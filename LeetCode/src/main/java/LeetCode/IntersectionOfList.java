package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 下午5:47
 * To change this template use File | Settings | File Templates.
 */

import common.ListNode;

/**
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = 0;
        int lenB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }
        pA = headA;
        pB = headB;

        if (lenA > lenB) {
            int diff = lenA - lenB;
            int i = 0;
            while (i < diff) {
                pA = pA.next;
                i++;
            }
        } else if (lenA < lenB) {
            int diff = lenB - lenA;
            int i = 0;
            while (i < diff) {
                pB = pB.next;
                i++;
            }
        }

        while (pA != null && pB != null) {
            if (pA == pB) return pA;
            else {
                pA = pA.next;
                pB = pB.next;
            }
        }
        return null;
    }
}
