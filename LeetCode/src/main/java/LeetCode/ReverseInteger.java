package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-3-11
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */
public class ReverseInteger {

	public int reverse(int x) {
		boolean neg = false;
		if (x < 0) {
			if (x <=  Integer.MIN_VALUE) return 0;
			neg = true;
			x = Math.abs(x);
		}
		int m = x%10;
		int n = x/10;
		int r = 0;
		while (n != 0) {
			if (r > Integer.MAX_VALUE - m) return 0;
			r += m;
			if (r > Integer.MAX_VALUE / 10) return 0;
			r = r*10;
			m = n%10;
			n = n/10;
			System.out.println(r + "\t" + m + "\t" + n);
		}
		r += m;
		if (neg) return -r;
		return r;
	}

	public static void main(String[] args) {
		ReverseInteger reverseInteger = new ReverseInteger();
		System.out.println(reverseInteger.reverse(-21474838));
		System.out.println(Integer.MAX_VALUE + "\t" + Integer.MIN_VALUE);
	}
}
