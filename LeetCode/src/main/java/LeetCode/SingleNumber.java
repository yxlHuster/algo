package LeetCode;

/**
 * Created by author on 5/25/15.
 */

/**
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     * @param array
     * @return
     */
    public int singleNumber(int[] array) {
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            x = x ^ array[i];
        }
        return x;
    }


    /**
     *
     * Given an array of integers, every element appears three times except for one. Find that single one.
     * @param A
     * @return
     */
    public int singleNumber3(int[] A) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] array = {12, 12, 1, 1, 2, 3, 3};
        System.out.println(singleNumber.singleNumber(array));
    }


}
