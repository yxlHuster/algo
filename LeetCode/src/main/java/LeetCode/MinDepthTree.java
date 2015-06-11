package LeetCode;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-9
 * Time: 下午4:44
 * To change this template use File | Settings | File Templates.
 */
public class MinDepthTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.right), minDepth(root.right));
    }


    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Integer> deps = new LinkedList<Integer>();
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        deps.push(1);
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int curr = deps.pop();
            if (node.left == null && node.right == null) return curr;
            if (node.left != null) {
                nodes.push(node.left);
                deps.push(curr + 1);
            }
            if (node.right != null) {
                nodes.push(node.right);
                deps.push(curr + 1);
            }
        }
        return 0;
    }

}
