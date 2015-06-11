package web;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by author on 5/10/15.
 */

/**
 * 思路：先把10000以内的完数算出来
 * 循环为i=i+2,这说明完数只有在偶数里
 * 有，奇数在一个小的范围内没有完数
 * 如6=1+2+3.8!=1+2+4
 */
public class PerfectNumber {


    public List<Integer> findPerfectNumbers(int max) {
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 2; i <= max; i += 2) {
            int sum = 1;
            for (int j = 2; j <= i / 2; j++) {
                if (i%j == 0) sum += j;
            }
            if (sum == i) results.add(i);
        }
        return results;
    }

    /**
     * 是否素数
     * @param n
     * @return
     */
    public boolean isPrime(int n) {
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            if (a < b) {
                b = b - a;
            }
        }
        return a;
    }

    /**
     * 最小公倍数
     * @param a
     * @param b
     * @return
     */
    public int mcd(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        PerfectNumber perfectNumber = new PerfectNumber();
        System.out.println(perfectNumber.findPerfectNumbers(1111));
        System.out.println(perfectNumber.gcd(12, 11));
        System.out.println(perfectNumber.mcd(12, 12));
    }
}
