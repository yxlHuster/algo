package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-5-31
 * Time: 下午5:51
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashSet;
import java.util.LinkedList;

/**
 * description:http://www.programcreek.com/2012/12/leetcode-word-ladder/
 */
public class WordLadder {


    /**
     * breath first search
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict == null || dict.isEmpty()) return 0;
        dict.add(end);
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> currentDistance = new LinkedList<Integer>();

        wordQueue.push(start);
        currentDistance.push(1);

        int result = Integer.MAX_VALUE;
        while (!wordQueue.isEmpty()) {
            String currentWord = wordQueue.pop();
            int currentDist = currentDistance.pop();
            if (currentWord.equals(end)) {
                result = Math.min(result, currentDist);
            }
            char[] currentArray = currentWord.toCharArray();
            for (int i = 0; i < currentArray.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == currentArray[i]) continue;
                    currentArray[i] = c;
                    String newWord = new String(currentArray);
                    if (dict.contains(newWord)) {
                        wordQueue.push(newWord);
                        currentDistance.push(currentDist + 1);
                        dict.remove(newWord);
                    }

                }
            }
        }
        if (result == Integer.MAX_VALUE) result = 0;
        return result;
    }
}
