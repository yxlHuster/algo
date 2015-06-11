package LeetCode;

import common.ListNode;

/**
 * Created by author on 6/8/15.
 */
public class SortedListToBST {

    static ListNode l;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int len = getLen(head);
        return sortedListToBST(0, len - 1);
    }
    public int getLen(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) >> 1;
        TreeNode left = sortedListToBST(start, mid -1);
        TreeNode root = new TreeNode(l.val);
        l = l.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

}
