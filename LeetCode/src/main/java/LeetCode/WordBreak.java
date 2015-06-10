package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by allen on 5/28/15.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    public boolean wordBreakHelper(String s, Set<String> dict, int start) {
        if (start == s.length()) return true;
        for (String d : dict) {
            int len = d.length();
            int end = start + len;
            if (end > s.length()) continue;
            if (s.substring(start, end).equals(d)) {
                if (wordBreakHelper(s, dict, end)) return true;
            }
        }
        return false;
    }

    public boolean wordBreakByDP(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!t[i]) continue;
            for (String d : dict) {
                int len = d.length();
                int end = i + len;
                if (end > s.length()) continue;
                if (t[end]) continue;
                if (s.substring(i, end).equals(d)) t[end] = true;

            }
        }
        return t[s.length()];
    }

    /**
     *
     * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences. For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"], the solution is ["cats and dog", "cat sand dog"].
     */

    public static List<String> wordBreak2(String s, Set<String> dict) {
        //create an array of ArrayList<String>
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();

        for(int i=0; i<s.length(); i++){
            if( dp[i] == null )
                continue;

            for(String word:dict){
                int len = word.length();
                int end = i+len;
                if(end > s.length())
                    continue;

                if(s.substring(i,end).equals(word)){
                    if(dp[end] == null){
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }

        List<String> result = new LinkedList<String>();
        if(dp[s.length()] == null)
            return result;

        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, s.length(), result, temp);

        return result;
    }

    /**
     * http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
     * @param dp
     * @param end
     * @param result
     * @param tmp
     */

    public static void dfs(List<String> dp[],int end,List<String> result, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i=tmp.size()-2; i>=0; i--){
                path += " " + tmp.get(i) ;
            }
            result.add(path);
            return;
        }

        for(String str : dp[end]){
            tmp.add(str);
            dfs(dp, end-str.length(), result, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

}
