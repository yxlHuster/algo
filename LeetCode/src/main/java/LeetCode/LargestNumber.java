package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 下午6:00
 * To change this template use File | Settings | File Templates.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. (Note: The result may be very large, so you need to return a string instead of an integer.)
 *
 *
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] numstrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numstrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numstrs, new Comparator<String>() {

            public int compare(String s1, String s2) {


                String left = s1 + s2;
                String right = s2 + s1;
                return -left.compareTo(right);

                //return -s1.compareTo(s2);  //303 other than 330
            }

        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < numstrs.length; i++) {
            sb.append(numstrs[i]);
        }
        // delete o in head
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] a = {3, 30, 34, 5, 9};
        System.out.println(largestNumber.largestNumber(a));
    }
}
