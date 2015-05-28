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

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev != 0 && Integer.MAX_VALUE / rev < 10
                    && Integer.MAX_VALUE / rev > -10)
                return 0;
            rev += rev * 10 + x%10;
            x /= 10;
        }
        return rev;
    }

    public int reverse3(int x) {
        int max = 1 << 31;
        int ret = 0;
        for (; x != 0; x/=10) {
            if (ret != 0 && max/ret < 10 && max/ret > -10)
                return 0;
            ret += ret * 10 + x%10;
        }
        return ret;
    }

	public static void main(String[] args) {
		ReverseInteger reverseInteger = new ReverseInteger();
		System.out.println(reverseInteger.reverse(-21474838));
		System.out.println(Integer.MAX_VALUE + "\t" + Integer.MIN_VALUE);
	}
}
