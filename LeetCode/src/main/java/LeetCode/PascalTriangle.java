package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;

/**
 *
 * Given numRows, generate the first numRows of Pascal's triangle. For example, given numRows = 5, the result should be:

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) return result;
        ArrayList<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        result.add(prev);

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 0; j < prev.size() - 1; i++) {
                temp.add(prev.get(j) + prev.get(j + 1));
            }
            temp.add(1);
            result.add(temp);
            prev = temp;
        }
        return result;
    }
}
