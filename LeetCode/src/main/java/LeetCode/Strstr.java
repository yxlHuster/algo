package LeetCode;

/**
 * Created by allen on 6/5/15.
 */

/**
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Strstr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) return -1;
            int m = i;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(m) == needle.charAt(j)) {
                    if (j == needle.length() - 1) return i;
                    m++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }


    public int strStr2(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) return -1;
            String sub = haystack.substring(i, i + needle.length());
            if (sub.equals(needle)) return i;
        }
        return -1;
    }

    public int strStrKmp(String haystack, String needle) {
        if(haystack == null || needle == null) return 0;

        int h = haystack.length();
        int n = needle.length();

        if (n > h) return -1;
        if (n == 0) return 0;

        int[] next = getNext(needle);
        int i = 0;

        while (i <= h - n) {
            int success = 1;
            for (int j = 0; j < n; j++) {
                if (needle.charAt(0) != haystack.charAt(i)) {
                    success = 0;
                    i++;
                    break;
                } else if (needle.charAt(j) != haystack.charAt(i + j)) {
                    success = 0;
                    i = i + j - next[j - 1];
                    break;
                }
            }
            if (success == 1)
                return i;
        }

        return -1;
    }

    //calculate KMP array
    public int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;

        for (int i = 1; i < needle.length(); i++) {
            int index = next[i - 1];
            while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
                index = next[index - 1];
            }

            if (needle.charAt(index) == needle.charAt(i)) {
                next[i] = next[i - 1] + 1;
            } else {
                next[i] = 0;
            }
        }

        return next;
    }
    public static void main(String[] args) {
        Strstr strstr = new Strstr();
        System.out.println(strstr.strStr("abcd", "cd"));
        System.out.println(strstr.strStr2("abcd", "cd"));
    }
}
