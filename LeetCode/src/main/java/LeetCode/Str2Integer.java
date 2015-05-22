package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-3-11
 * Time: 下午5:39
 * To change this template use File | Settings | File Templates.
 */
public class Str2Integer {

	public int atoi(String str) {
		if (str == null || str.isEmpty()) return 0;
		double result = 0;
		boolean n = false;
		int i = 0;
		int neg = 1;
		while (i < str.length()) {
			if (Character.isSpaceChar(str.charAt(i)) && !n) {
				i++;
				continue;
			}
			if (!Character.isDigit(str.charAt(i)) && n) break;
			if (str.charAt(i) == '-' || str.charAt(i) == '+') {
				if ( (i + 1 < str.length()) && !Character.isDigit(str.charAt(i + 1)) ) return (int)result;
				if (str.charAt(i) == '-') neg = -1;
				i++;
				continue;
			}
			if (Character.isDigit(str.charAt(i))) {
				result *= 10;
				result += str.charAt(i) - '0';
				n = true;
			} else {
				break;
			}
			 i++;
		}
		result *= neg;
		if (result < Integer.MIN_VALUE) result = Integer.MIN_VALUE;
		if (result > Integer.MAX_VALUE) result = Integer.MAX_VALUE;
		return (int)result;
	}

	public static void main(String[] args) {
		Str2Integer str2Integer = new Str2Integer();
		System.out.println(Integer.MIN_VALUE + "\t" + Integer.MAX_VALUE);
		System.out.println(str2Integer.atoi("   +0 123"));
	}
}
