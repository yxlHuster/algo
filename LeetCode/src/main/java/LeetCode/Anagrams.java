package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-12
 * Time: 下午6:01
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;

/**
 *
 * If two strings are anagram to each other, their sorted sequence is the same. Therefore, this problem can be seen as a problem of finding duplicate elements.
 */
public class Anagrams {

    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) return result;
        Map<String, List<Integer>> mps = new HashMap<String, List<Integer>>(); // string and pos list
        for (int i = 0; i < strs.length; i++) {
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);
            String sorted = String.valueOf(strArr);
            if (mps.containsKey(sorted)) {
                mps.get(sorted).add(i);
            } else {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                mps.put(sorted, temp);
            }
        }

        for (List<Integer> l : mps.values()) {
            if (l.size() > 1) {
                for (Integer i : l) {
                    result.add(strs[i]);
                }
            }
        }
        return result;
    }
}
