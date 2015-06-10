package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-10
 * Time: 下午6:14
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example, if n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || n < k) return result;
        ArrayList<Integer> current = new ArrayList<Integer>();
        dfs(n, k , 1, current, result);
        return result;
    }
    private void dfs(int n, int k, int start, ArrayList<Integer> current,
                     ArrayList<ArrayList<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = start; i < n; i++) {
            current.add(i);
            dfs(n, k, i+1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
