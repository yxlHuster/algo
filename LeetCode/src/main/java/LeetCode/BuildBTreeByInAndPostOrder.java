package LeetCode;

/**
 * Created by allen on 6/6/15.
 */

/**
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * in-order:   4 2 5  (1)  6 7 3 8
 * post-order: 4 5 2  6 7 8 3  (1)
 *
 * From the post-order array, we know that last element is the root. We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.
 * Using the length of left sub-tree, we can identify left and right sub-trees in post-order array. Recursively, we can build up the tree.
 */
public class BuildBTreeByInAndPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int iStart = 0;
        int iEnd = inorder.length - 1;
        int pStart = 0;
        int pEnd = postorder.length - 1;
        return buildTree(inorder, iStart, iEnd, postorder, pStart, pEnd);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        // why not use inStart, inEnd to get rIndex
        int rIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rIndex = i;
                break;
            }
        }
        root.left = buildTree(inorder, inStart, rIndex-1, postorder, postStart, postStart+ rIndex - (inStart+1));
        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.right = buildTree(inorder, rIndex+1, inEnd, postorder, postStart + rIndex - inStart, postEnd-1);
        // postStart+k-inStart = postStart+k-(inStart+1) +1
        return root;

    }

}
