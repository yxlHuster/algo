package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class SymmetricTree {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (l == null || r == null) {
            return false;
        }
        if (l.value != r.value) return false;
        if (!isSymmetric(l.left, l.right)) {
            return false;
        }
        if (!isSymmetric(r.left, r.right)) {
            return false;
        }
        return true;
    }
}
