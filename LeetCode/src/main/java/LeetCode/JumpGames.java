package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午5:52
 * To change this template use File | Settings | File Templates.
 */
public class JumpGames {

    public boolean canJump(int[] A) {
        if (A.length <= 0) return true;
        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            if (max <= i && A[i] == 0) return false;
            if (i + A[i] > max) {
                max = i + A[i];
            }
            if (max >= A.length - 1) return true;
        }
        return false;
    }

}
