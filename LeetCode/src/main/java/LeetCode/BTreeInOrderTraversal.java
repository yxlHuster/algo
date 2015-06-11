package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by author on 5/25/15.
 */

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class BTreeInOrderTraversal {

    /**
     * left->parent->right
     * @param root
     * @return
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> paths = new ArrayList<Integer>();
        if (root == null) return paths;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                paths.add(t.value);
                p = t.right;
            }
        }
        return paths;
    }

    /**
     * left->right->parent
     * @param root
     * @return
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> paths = new ArrayList<Integer>();
        if (root == null) return paths;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            /**
             *
             *
             * go down the tree.
             * check if current node is leaf, if so, process it and pop stack,
             * otherwise, keep going down
            */
            if (prev == null || current.left == null || current.right == null) {
                //prev == null is the situation for the root node
                if (current.left != null) stack.push(current.left);
                else if (current.right != null) stack.push(current.right);
                else {
                    stack.pop();
                    paths.add(current.value);
                }
            }
            /**
             * go up the tree from left node
             * need to check if there is a right child
             * if yes, push it to stack
             * otherwise, process parent and pop stack
             */
            else if (current.left == prev){
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    paths.add(current.value);
                }
            }
            /**
             *
             * go up the tree from right node
             * after coming back from right node, process parent node and pop stack.
             */
            else if (current.right == prev) {
                stack.pop();
                paths.add(current.value);
            }
            prev = current;
        }
        return paths;
    }

    /**
     * parent->left->right
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> paths = new ArrayList<Integer>();
        if (root == null) return paths;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            paths.add(t.value);
            if (t.right != null) stack.push(t.right);
            if (t.left != null) stack.push(t.left);
        }
        return paths;
    }
}
