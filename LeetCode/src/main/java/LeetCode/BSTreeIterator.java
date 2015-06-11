package LeetCode;

/**
 * Created by allen on 6/11/15.
 */

import java.util.Stack;

/**
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST. Calling next() will return the next smallest number in the BST. Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 */
public class BSTreeIterator {

    Stack<TreeNode> stack;

    public BSTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        int result = node.value;
        TreeNode root = node.right;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        return result;
    }

}
