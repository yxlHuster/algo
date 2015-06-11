package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-3-12
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class ZigZagConv {

	public String convert(String s, int nRows) {
		if (s == null || s.length() <= nRows || nRows <= 1) return s;
		StringBuffer sb = new StringBuffer();

		// the first row
		for (int i = 0; i < s.length(); i += (nRows - 1) * 2) {
			sb.append(s.charAt(i));
		}

		for (int i = 1; i < nRows - 1; i++) {
			for (int j = i; j < s.length(); j+= (nRows - 1) * 2) {
				sb.append(s.charAt(j));
				if (j + (nRows - i - 1) * 2 < s.length()) {
					sb.append(s.charAt(j + (nRows - i - 1) * 2));
				}
			}
		}
		// the last row
		for (int i = nRows - 1; i < s.length(); i += (nRows - 1) * 2) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		ZigZagConv zigZagConv = new ZigZagConv();
		zigZagConv.convert("PAYPALISHIRING", 3);
	}
}
