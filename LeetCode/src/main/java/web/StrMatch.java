package web;

/**
 * Created by author on 5/3/15.
 */

/**
 *
 * 假设两个字符串中所含有的字符和个数都相同我们就叫这两个字符串匹配，
 * 比如：abcda和adabc,由于出现的字符个数都是相同，只是顺序不同
 */
public class StrMatch {


    public boolean isMatch(String src, String dest) {
        if (src == null || dest == null) return false;
        int srcLen = src.length();
        int destLen = dest.length();
        if (srcLen == 0 || destLen == 0 || srcLen != destLen) return false;
        int[] charFreq = new int[256];
        for (Character c : src.toCharArray()) {
            charFreq[c]++;
        }
        for (Character c: dest.toCharArray()) {
            charFreq[c]--;
        }

        for (Integer i : charFreq) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StrMatch strMatch = new StrMatch();
        String src = "";
        String dest = "adabc";
        System.out.println(strMatch.isMatch(src, dest));
    }
}
