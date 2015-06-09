package LeetCode;

/**
 * Created by allen on 6/9/15.
 */

/**
 *
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree. For example, given the below binary tree
 *
 *       1
 / \
 2   3
 the result is 6.
 *
 * 1) Recursively solve this problem
 2) Get largest left sum and right sum
 2) Compare to the stored maximum
 * 任意联通的两点
 */
public class BTreeMaxPathSum {


    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public int calculateSum(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);
        int current = Math.max(root.value, Math.max(root.value + left, root.value + right));
        max[0] = Math.max(max[0], Math.max(current, root.value + left + right));
        return current;
    }

    public int maxSum(TreeNode root) {
        if (root == null) return 0;
        int value = root.value;
        int lmax = 0;
        int rmax = 0;
        if (root.left != null) {
            lmax = maxSum(root.left);
            if (lmax > 0) {
                value += lmax;
            }
        }
        if (root.right != null) {
            rmax = maxSum(root.right);
            if (rmax > 0) {
                value += rmax;
            }
        }

        //max is the max of {root.val,root.val+lmax,root.val+rmax, root.val + lmax + rmax}
        if (value > max) {
            max = value;
        }
        //return max of (root.val, root.val + lmax, root.val + rmax)
        return  Math.max(root.value, Math.max(root.value + lmax, root.value + rmax));
    }



}
