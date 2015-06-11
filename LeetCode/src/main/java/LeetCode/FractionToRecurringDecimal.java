package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.programcreek.com/2014/03/leetcode-fraction-to-recurring-decimal-java/
 *
 *
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";
        String result = "";
        // is result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        long res = num / den;
        result += String.valueOf(res);

        long remainder = (num % den) * 10;
        if (remainder == 0) {
            return result;
        }

        // right-hand side of decimal point
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int begin = map.get(remainder);
                String part1 = result.substring(0, begin);
                String part2 = result.substring(begin, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }
            //
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) *10;
        }
        return result;
    }
}
