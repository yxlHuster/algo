package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-3-11
 * Time: 上午9:15
 * To change this template use File | Settings | File Templates.
 */
public class LongestSubStrWithoutRepeat {

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

    public int lengthOfLongestSubstring2(String s) {
        boolean[] flag = new boolean[256];

        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {
                result = Math.max(result, i - start);
                // the loop update the new start point
                // and reset flag array
                // for example, abccab, when it comes to 2nd c,
                // it update start from 0 to 3, reset flag for a,b
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }

        result = Math.max(arr.length - start, result);

        return result;
    }


    public static int lengthOfLongestSubstring3(String s) {

        char[] arr = s.toCharArray();
        int pre = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                pre = Math.max(pre, map.size());
                i = map.get(arr[i]);
                map.clear();
            }
        }

        return Math.max(pre, map.size());
    }


	public static void main(String[] args) {
		LongestSubStrWithoutRepeat longestSubStr = new LongestSubStrWithoutRepeat();
		String s = "bbbbb";//eee
		System.out.println(longestSubStr.lengthOfLongestSubstring(s));
	}
}
