package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-10
 * Time: 下午4:57
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times.

 Note: All numbers (including target) will be positive integers. Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak). The solution set must not contain duplicate combinations. For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:

 [7]
 [2, 2, 3]
 *  The first impression of this problem should be depth-first search(DFS). To solve DFS problem, recursion is a normal implementation.

 Note that the candidates array is not sorted, we need to sort it first.
 *
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        ArrayList<Integer> current = new ArrayList<Integer>();
        combinationSum(candidates, target, 0, current, result);
        return result;
    }

    public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            result.add(temp);
            return;
        }

        for (int i = j; i < candidates.length; i++) {
            if (candidates[i] > target) return;
            curr.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i,  curr, result);
            curr.remove(curr.size() - 1);
        }

    }

}


