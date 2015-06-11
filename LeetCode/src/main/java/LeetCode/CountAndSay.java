package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午6:17
 * To change this template use File | Settings | File Templates.
 */
public class CountAndSay {


    public String countAndSay(int n) {
        if (n <= 0) return null;
        String result = "1";
        int i = 1;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int k = 1; k < result.length(); k++) {
                if (result.charAt(k) == result.charAt(k - 1)) count++;
                else {
                    sb.append(count).append(result.charAt(k-1));
                    count = 1;
                }
            }
            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result;
    }
}
