package LeetCode;

/**
 * Created by allen on 6/12/15.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum
 */
public class PathsSum {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        List<Integer> current = new ArrayList<Integer>();
        current.add(root.value);
        dfs(root, current, sum - root.value, result);
        return result;
    }


    public void dfs(TreeNode root, List<Integer> current, int target, List<List<Integer>> result) {
        if (root.left == null && root.right == null && target == 0) {
            result.add(new ArrayList<Integer>(current));
        }

        if (root.left != null) {
            current.add(root.left.value);
            dfs(root.left, current, target - root.left.value, result);
            current.remove(current.size() - 1);
        }
        if (root.right != null) {
            current.add(root.right.value);
            dfs(root.right, current, target - root.right.value, result);
            current.remove(current.size() - 1);
        }
    }


    public List<List<Integer>> pathSum2(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> sumValues = new LinkedList<Integer>();

        nodes.add(root);
        sumValues.add(root.value);

        LinkedList<List<Integer>> l = new LinkedList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>();

        a.add(root.value);
        l.add(a);


        while(!nodes.isEmpty()){

            Integer sumValue = sumValues.poll();
            TreeNode t = nodes.poll();
            a = l.poll();


            if(t.left == null && t.right == null && sumValue == sum){
                result.add(a);
            }
            else{
                if(t.right != null) {
                    nodes.add(t.right);
                    sumValues.add(t.right.value + sumValue);
                    List<Integer> r = new ArrayList<Integer>();
                    r.addAll(a);
                    r.add(t.right.value);
                    l.add(r);
                }
                if(t.left != null) {
                    nodes.add(t.left);
                    sumValues.add(t.left.value + sumValue);
                    List<Integer> le = new ArrayList<Integer>();
                    le.addAll(a);
                    le.add(t.left.value);
                    l.add(le);
                }
            }
        }
        return result;
    }

}
