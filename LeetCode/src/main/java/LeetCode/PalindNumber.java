package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-3-11
 * Time: 下午9:01
 * To change this template use File | Settings | File Templates.
 */
public class PalindNumber {

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
		}
		r += m;
		if (neg) return -r;
		return r;
	}

	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		int r = reverse(x);
		if (r == x) return true;
		return false;
	}

	public boolean isPalindome2(int x) {
		if (x < 0) return false;
		if (x <= 9) return true;
		int base = 1;
		while (x / base >= 10) {
			base *= 10;
		}
		while(x != 0) {
			int leftDigit = x / base;
			int rightDigit = x % 10;
			if (leftDigit != rightDigit) return false;
			x -= leftDigit * base;
			x /= 10;
			base /= 100;
		}
		return true;
	}

    public boolean isPalindrome3(int x) {
        //negative numbers are not palindrome
        if (x < 0) return false;
        int dev = 1;
        // initialize how many zeros
        while (x / dev >= 10) {
            dev *= 10;
        }
        while ( x != 0) {
            int left = x / dev;
            int right = x % 10;
            if (left != right) return false;
            x = (x%dev)/10;//
            dev /= 100; //
        }
        return true;
    }

	public static void main(String[] args) {
		PalindNumber palindNumber = new PalindNumber();
		System.out.println(palindNumber.isPalindome2(1221));
	}
}
