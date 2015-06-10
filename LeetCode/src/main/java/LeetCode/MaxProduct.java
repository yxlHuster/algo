package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-10
 * Time: 下午6:44
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaxProduct {


    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) return 0;
        int maxLocal = A[0];
        int minLocal = A[0];
        int global = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(maxLocal * A[i], A[i]), A[i] * minLocal);
            minLocal = Math.min(Math.min(temp * A[i], A[i]), A[i] * minLocal);
            global = Math.max(global, maxLocal);
        }
        return global;
    }

    public static void main(String[] args) {
        int[]  A = {2,3,-2,4};
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(A));
    }
}
