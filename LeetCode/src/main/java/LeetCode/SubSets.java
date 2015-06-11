package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-9
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * Given a set of distinct integers, S, return all possible subsets.
 * Note: 1) Elements in a subset must be in non-descending order. 2) The solution set must not contain duplicate subsets.
 */

/**
 * For example, given S = [1,2,3], the method returns:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set S of n distinct integers, there is a relation between Sn and Sn-1. The subset of Sn-1 is the union of {subset of Sn-1} and {each element in Sn-1 + one more element}. Therefore, a Java solution can be quickly formalized.
 */
public class SubSets {

    public ArrayList<ArrayList<Integer>> subsets(int[] s) {
        if (s == null || s.length == 0) return null;
        Arrays.sort(s);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < s.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            //get sets that are already in result
            for (ArrayList a : results) {
                temp.add(new ArrayList<Integer>(a));
            }
            //add S[i] to existing sets
            for (ArrayList a : temp) {
                a.add(s[i]);
            }
            //add S[i] only as a set
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(s[i]);
            temp.add(single);
            results.addAll(temp);
        }
        //add empty set
        results.add(new ArrayList<Integer>());
        return results;
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num == null)
            return null;

        Arrays.sort(num);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

        for (int i = num.length-1; i >= 0; i--) {

            //get existing sets
            if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
                prev = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < result.size(); j++) {
                    prev.add(new ArrayList<Integer>(result.get(j)));
                }
            }

            //add current number to each element of the set
            for (ArrayList<Integer> temp : prev) {
                temp.add(0, num[i]);
            }

            //add each single number as a set, only if current element is different with previous
            if (i == num.length - 1 || num[i] != num[i + 1]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(num[i]);
                prev.add(temp);
            }

            //add all set created in this iteration
            for (ArrayList<Integer> temp : prev) {
                result.add(new ArrayList<Integer>(temp));
            }
        }

        //add empty set
        result.add(new ArrayList<Integer>());

        return result;
    }
}
