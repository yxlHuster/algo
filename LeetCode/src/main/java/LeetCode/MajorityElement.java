package LeetCode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 下午4:07
 * To change this template use File | Settings | File Templates.
 */


/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    public int majorityElement(int[] num) {
        if (num.length == 1) {
            return num[0];
        }

        Arrays.sort(num);
        return num[num.length / 2];
    }

    public int majorityElement2(int[] num) {
        if (num.length == 1) {
            return num[0];
        }

        int candidate  = num[0];
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (count == 0) {
                candidate  = num[i];
                count = 1;
            } else {
                if (num[i] == candidate ) count++;
                else count--;
            }
        }
        return candidate ;
    }


    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] array = {1, 2, 3, 4, 1, 1, 1};
        System.out.println(majorityElement.majorityElement2(array));
    }


}
