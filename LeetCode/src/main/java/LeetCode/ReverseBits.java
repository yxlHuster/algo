package LeetCode;

/**
 * Created by allen on 6/11/15.
 */

/**
 * Reverse bits of a given 32 bits unsigned integer.
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;
    }

    public static int swapBits(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }

    public static int reverseBits2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n & 0x01);
            n >>= 1;
        }
        int len = sb.toString().length();
        if (len < 32) {
            for (int i = 0; i < 32 - len; i++) {
                sb.append("0");
            }
        }
        int k = 0;
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            k += Math.pow(2, p) * Integer.valueOf(sb.charAt(i) - '0');
            p++;
        }
        return k;

    }

    public static void main(String[] args) {
        System.out.println(reverseBits2(43261596));
        System.out.println(reverseBits(43261596));
    }

}
