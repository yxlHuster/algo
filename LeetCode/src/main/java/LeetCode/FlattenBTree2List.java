package LeetCode;

/**
 * Created by author on 6/6/15.
 */

import java.util.Stack;

/**
 *
 *
 * Given a binary tree, flatten it to a linked list in-place.
 */
/**
 * http://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
 */
public class FlattenBTree2List {


    public void flatten(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                p.right = temp;
            }
            p = p.right;
        }

    }

}
