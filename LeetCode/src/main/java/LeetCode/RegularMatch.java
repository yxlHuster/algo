package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-3-12
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class RegularMatch {

	public boolean isMatch(String s, String p) {

		if (p.length() == 0) return s.length() == 0;
		if (p.length() == 1) {
			if (s.length() < 1) return false;
			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		if (p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false;
			}
			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		} else {
			//case 2.1: a char & '*' can stand for 0 element
			if (isMatch(s, p.substring(2))) {
				return true;
			}

			//case 2.2: a char & '*' can stand for 1 or more preceding element,
			//so try every sub string
			int i = 0;
			while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}

	public boolean isMatch2(String s, String p) {

		if(p.length() == 0)
			return s.length() == 0;

		//p's length 1 is special case
		if(p.length() == 1 || p.charAt(1) != '*'){
			if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch(s.substring(1), p.substring(1));

		}else{
			int len = s.length();

			int i = -1;
			while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
				if(isMatch(s.substring(i+1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		RegularMatch regularMatch = new RegularMatch();
		String s = "a";
		String p = "*";
		System.out.println(regularMatch.isMatch(s, p));
	}
}
