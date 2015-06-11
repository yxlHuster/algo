package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-9
 * Time: 下午3:27
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * http://www.programcreek.com/2013/01/leetcode-distinct-subsequences-total-java/
 */
public class DistinctSubsequencesTotal {

    /**
     * Let W(i, j) stand for the number of subsequences of S(0, i) equals to T(0, j). If S.charAt(i) == T.charAt(j), W(i, j) = W(i-1, j-1) + W(i-1,j); Otherwise, W(i, j) = W(i-1,j).
     * @param S
     * @param T
     * @return
     */
    public int numDistincts(String S, String T) {
        int[][] table = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    table[i][j] += table[i - 1][j - 1] + table[i - 1][j];
                } else {
                    table[i][j] += table[i - 1][j];
                }
            }
        }
        return table[S.length()][T.length()];
    }


    public int numDistinct2(String S, String T) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();

        for (int i = 0; i < T.length(); i++) {
            if (map.containsKey(T.charAt(i))) {
                map.get(T.charAt(i)).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                map.put(T.charAt(i), temp);
            }
        }

        int[] result = new int[T.length() + 1];
        result[0] = 1;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (map.containsKey(c)) {
                ArrayList<Integer> temp = map.get(c);
                int[] old = new int[temp.size()];

                for (int j = 0; j < temp.size(); j++)
                    old[j] = result[temp.get(j)];

                // the relation
                for (int j = 0; j < temp.size(); j++)
                    result[temp.get(j) + 1] = result[temp.get(j) + 1] + old[j];
            }
        }

        return result[T.length()];
    }




}
