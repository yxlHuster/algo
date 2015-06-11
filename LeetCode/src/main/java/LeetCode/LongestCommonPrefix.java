package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 *  Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLen) minLen = s.length();
        }
        if (minLen == 0) return "";
        for (int j = 0; j < minLen; j++) {
            for (int i = 0; i < strs.length; i++) {
                char prev = '0';
                if (i == 0) {
                    prev = strs[i].charAt(j);
                    continue;
                }
                if (strs[i].charAt(j) != prev) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }

}
