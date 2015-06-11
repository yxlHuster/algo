package LeetCode;

/**
 * Created by author on 6/6/15.
 */


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 *
 */
public class PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> vals = new LinkedList<Integer>();

        nodes.push(root);
        vals.push(root.value);

        while (!nodes.isEmpty()) {

            TreeNode currentNode = nodes.pop();
            int currentSum = vals.pop();
            if (currentNode.left == null && currentNode.right == null && currentSum == sum) return true;
            if (currentNode.left != null) {
                nodes.push(currentNode.left);
                vals.push(currentSum + currentNode.left.value);
            }
            if (currentNode.right != null) {
                nodes.push(currentNode.right);
                vals.push(currentSum + currentNode.right.value);
            }

        }
        return false;


    }


    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.value == sum && root.left == null && root.right == null) return true;
        return hasPathSum2(root.left, sum - root.value) || hasPathSum2(root.right, sum - root.value);
    }
}
