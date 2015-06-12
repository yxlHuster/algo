package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-12
 * Time: 下午5:48
 * To change this template use File | Settings | File Templates.
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);

        for (int i = 4; i < n; i++) {
            boolean isprime = true;
            /*
            for (Integer p : primes) {
                int m = i % p;
                if (m == 0) {
                    isprime = false;
                    break;
                }
            }
            */
            for (int j = 2; j <= Math.sqrt(i); i++) {
                if (i%j == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime) primes.add(i);
        }

        return primes.size();

    }


    /**
     *
     * This solution is the implementation of Sieve of Eratosthenes.
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        if (n <= 2)
            return 0;

        // init an array to track prime numbers
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++)
            primes[i] = true;

        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            // or for (int i = 2; i <= n-1; i++) {
            if (primes[i]) {
                for (int j = i + i; j < n; j += i)
                    primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }

        return count;
    }

}
