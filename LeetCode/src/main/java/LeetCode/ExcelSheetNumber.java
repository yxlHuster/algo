package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午3:46
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 *
 */
public class ExcelSheetNumber {

    /**
     *
     * 1-A,2-B,26-Z,27-AA
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        if (n < 0) throw new IllegalArgumentException("Input is not valid!");
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char c = (char)((n%26) + 'A');
            n /= 26;
            sb.append(c);
        }
        sb.reverse();
        return sb.toString();
    }


    /**  http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-number-java/
     * AA-27, Z-26,AB-28
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            throw new IllegalArgumentException("Input is not valid!");
        }
        int result = 0;
        int len = s.length() - 1;
        int p = 0;
        while (len >= 0) {
            result += Math.pow(26, p) * (s.charAt(len) - 'A' + 1);
            p++;
            len--;
        }
        return result;
    }



}
