package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-12
 * Time: 下午3:24
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Write an algorithm to determine if a number is "happy".
 * What is an happy number can be shown in the following example:

 19 is a happy number
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> sets = new HashSet<Integer>();
        while (!sets.contains(n)) {
            n = sum(getDigits(n));
            if (n == 1) return true;
        }
        return false;
    }

    public int sum(int[] arr) {
        int sum = 0;
        for (Integer i : arr) {
            sum += i;
        }
        return sum;
    }

    public int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] result = new int[s.length()];
        int i = 0;
        while (n != 0) {
            int mod = n % 10;
            result[i++] = mod;
            n = n / 10;
        }
        return result;
    }
}
