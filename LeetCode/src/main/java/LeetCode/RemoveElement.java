package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-12
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int i = 0;
        int j = 0;
        while (j < A.length) {
            if (A[j] != elem) {
                A[i]  = A[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
