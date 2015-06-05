package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-5-31
 * Time: 下午6:35
 * To change this template use File | Settings | File Templates.
 */

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
public class MergeTSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        int aLen = m - 1;
        int bLen = n - 1;
        int k = m + n -1;
        while (k >= 0) {
            if (bLen < 0 || (aLen > 0 && A[aLen] > B[bLen])) {
                A[k--] = A[aLen--];
            } else {
                A[k--] = B[bLen--];
            }
        }
    }


    public void merge2(int A[], int m, int B[], int n) {
        int aLen = m - 1;
        int bLen = n - 1;
        int k = m + n - 1;
        while (aLen > 0 && bLen > 0) {
            if (A[aLen] > B[aLen]) {
                A[k--] = A[aLen--];
            } else {
                A[k--] = B[bLen--];
            }
        }
        while (bLen > 0) {
            A[k--] = B[bLen--];
        }
    }
}
