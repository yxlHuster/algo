package LeetCode;

/**
 * Created by allen on 6/11/15.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom. For example, given the following binary tree,
 */
public class BTreeRightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.push(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.pop();
                if (i == 0) {
                    result.add(node.value);
                }
                if (node.right != null) {
                    queue.push(node.right);
                }
                if (node.left != null) {
                    queue.push(node.left);
                }
            }
        }
        return result;
    }

}
