package LeetCode;

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

}
