package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 下午8:49
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * Compare two version numbers version1 and version2. If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character. The . character does not represent a decimal point and is used to separate number sequences.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 *
 *
 */
public class CompareVersionNum {

    /**
     * The tricky part of the problem is to handle cases like 1.0 and 1. They should be equal.
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int i = 0;
        while (i < len1 || i < len2) {
            if (i < len1 && i < len2) {
                if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[i])) {
                    return -1;
                } else if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i])) {
                    return 1;
                }
            } else if (i < len1) {
                if (Integer.valueOf(v1[i]) != 0) return 1;
            } else if (i < len2) {
                if (Integer.valueOf(v2[i]) != 0) return -1;
            }
        }
        return 0;
    }


}
