package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-3-11
 * Time: 上午9:15
 * To change this template use File | Settings | File Templates.
 */
public class LongestSubStr {

	/*
	public int lengthOfLongestSubstring(String s) {
		if (s.isEmpty() || s == null) return 0;
		Map<Character, Integer> pos = new HashMap<Character, Integer>();
		int max = 0;
		int oldIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			if (pos.containsKey(s.charAt(i))) {
				oldIndex = pos.get(s.charAt(i));
				int offset = i - oldIndex;
				if (offset > max) {
					max = offset;
				}
			} else {
				max++;
			}
			pos.put(s.charAt(i), i);
		}
		return max;
	}
	*/
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.isEmpty()) return 0;
		HashSet<Character> set = new HashSet<Character>();
		int max = 0;
		int first = 0;
		int second = 0;
		while(second < s.length()) {
			if(set.contains(s.charAt(second))) {
				if(max < second - first) max = second - first;
				while(s.charAt(first) != s.charAt(second)) {
                    System.out.println("deleting char@ " + s.charAt(first) + " " + first + " " + second);
				//while (first != second) {
					set.remove(s.charAt(first));
					first++;
				}
				first++;
			} else {
				set.add(s.charAt(second));
			}
			second++;
		}
		System.out.println(first + "\t" + second);
		max = Math.max(max, second - first);
		return max;
	}

	public static void main(String[] args) {
		LongestSubStr longestSubStr = new LongestSubStr();
		String s = "abcdabd";//eee
		System.out.println(longestSubStr.lengthOfLongestSubstring(s));
	}
}
