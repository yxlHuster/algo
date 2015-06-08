package LeetCode;

/**
 * Created by allen on 6/8/15.
 */
public class SortedArray2BTree {

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }
}
