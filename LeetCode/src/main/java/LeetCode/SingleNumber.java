package LeetCode;

/**
 * Created by allen on 5/25/15.
 */

/**
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {

    public int singleNumber(int[] array) {
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            x = x ^ array[i];
        }
        return x;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] array = {12, 12, 1, 1, 2, 3, 3};
        System.out.println(singleNumber.singleNumber(array));
    }


}
