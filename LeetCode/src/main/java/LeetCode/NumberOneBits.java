package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 */

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOneBits {


    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n&0x01) == 1) count++;
            n >>= 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        for (int i = 1; i < 33; i++) {
            boolean b = (n&(1<<i)) != 0 ? true:false;
            if (b) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight2(11));
    }


}
