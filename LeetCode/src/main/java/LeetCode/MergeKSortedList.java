package LeetCode;

/**
 * Created by allen on 6/9/15.
 */

import common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedList
{

    /**
     * n * log(k) k is lists size
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty()) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        for (ListNode listNode : lists) {
            queue.add(listNode);
        }
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            p.next = temp;
            if (temp.next != null) {
                queue.add(temp.next);
            }
            p = p.next;
        }
        return head.next;
    }


}
