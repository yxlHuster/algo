package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-5-8
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class Pow {

    public int pow(int m, int n) {
        if (n < 0) return 1 / pow(m, -n);
        if (n == 0) return 1;
        int result = pow(m, n / 2);
        if ((n&0x01) == 0) return result * result;
        else return result * result * m;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.pow(2, 5));
        System.out.println(pow.pow(2, 6));

    }
}
