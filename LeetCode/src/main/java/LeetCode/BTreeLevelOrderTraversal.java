package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-12
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * For example, given binary tree {3,9,20,#,#,15,7},
 * return its level order traversal as [[15,7], [9,20],[3]]
 *
 *
 *
 */
public class BTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
        List<Integer> level = new ArrayList<Integer>();

        while (!current.isEmpty()) {
            TreeNode cur = current.pop();
            level.add(cur.value);
            if (cur.left != null) {
                next.add(cur.left);
            }
            if (cur.right != null) {
                next.add(cur.right);
            }
            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<TreeNode>();
                result.add(level);
                level = new ArrayList<Integer>();
            }
        }
        List<List<Integer>> reverse = new ArrayList<List<Integer>>();
        for (int i = current.size() - 1; i >= 0; i--) {
            reverse.add(result.get(i));
        }

        return reverse;
    }
}
