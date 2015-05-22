package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-5-8
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class Sqrt {

    public int sqrt(int m) {
        if (m <= 1) return m;
        if (m <= 2) return 1;
        int left = 1;
        int right = m / 2;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (m / mid < mid) {
                right = mid - 1;
            } else if (m / mid > mid) {
                left = mid + 1;
            } else {
                break;
            }
        }
        return mid;
    }

    /**
     * http://blog.csdn.net/doc_sgl/article/details/12404971
     * 牛顿迭代法
     * @param m
     * @return
     */
    public int newton(int x) {
        if (x == 0) return 0;
        double pre;
        double cur = 1;
        do
        {
            pre = cur;
            cur = x / (2 * pre) + pre / 2.0;
        } while (Math.abs(cur - pre) > 0.00001);
        return (int)cur;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(3));
        System.out.println(sqrt.sqrt(4));
        System.out.println(sqrt.newton(3));
        System.out.println(sqrt.newton(4));
    }
}
