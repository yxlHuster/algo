package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 上午9:49
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class PalindromePartition {


    /**
     * deep search
     * @param s
     * @return
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (s == null || s.length() == 0) {
            return result;
        }

        ArrayList<String> partition = new ArrayList<String>();//track each possible partition
        addPalindrome(s, 0, partition, result);

        return result;
    }

    private void addPalindrome(String s, int start, ArrayList<String> partition,
                               ArrayList<ArrayList<String>> result) {
        //stop condition
        if (start == s.length()) {
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    /**
     * dp
     * @param s
     * @return
     */
    public static List<String> palindromePartitioning(String s) {

        List<String> result = new ArrayList<String>();

        if (s == null)
            return result;

        if (s.length() <= 1) {
            result.add(s);
            return result;
        }

        int length = s.length();

        int[][] table = new int[length][length];

        // l is length, i is index of left boundary, j is index of right boundary
        for (int l = 1; l <= length; l++) {
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 1 || l == 2) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i + 1][j - 1];
                    }
                    if (table[i][j] == 1) {
                        result.add(s.substring(i, j + 1));
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }

        return result;
    }


    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome. Return the minimum cuts needed for a palindrome partitioning of s. For example, given s = "aab", return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();

        boolean dp[][] = new boolean[n][n];
        int cut[] = new int[n];

        for (int j = 0; j < n; j++) {
            cut[j] = j; //set maximum # of cut
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    // if need to cut, add 1 to the previous cut[i-1]
                    if (i > 0){
                        cut[j] = Math.min(cut[j], cut[i-1] + 1);
                    }else{
                        // if [0...j] is palindrome, no need to cut
                        cut[j] = 0;
                    }
                }
            }
        }
        return cut[n-1];
    }


}
