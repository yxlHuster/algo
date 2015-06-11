package LeetCode;

/**
 * Created by author on 6/9/15.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * This is a problem asked by Google.

 * Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".

  * http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 */
public class LongestSubStrWithKUniqChar {



    public static String maxSubString2UniqueChars(String s) {
        int maxLen = 0;
        String maxSubstring = null;
        int m = 0;

        // declare a map to track the right most position of the two characters
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if map contains 2 characters, process
            if (map.size() == 2 && !map.containsKey(c)) {
                if (i - m > maxLen) {
                    maxLen = i - m;
                    maxSubstring = s.substring(m, i);
                }

                // get the left most index for
                int leftMost = s.length();
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < leftMost) {
                        leftMost = entry.getValue();
                    }
                }

                m = leftMost + 1;
                map.remove(s.charAt(leftMost));
            }

            map.put(c, i);
        }

        if (map.size() == 2 && maxLen == 0) {
            return s;
        }

        return maxSubstring;
    }

    public static String maxSubStringKUniqueChars2(String s, int k) {
        int maxLen = 0;
        String maxSubstring = null;
        int m = 0;

        // declare a map to track the right most position of the two characters
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if map contains 2 characters, process
            if (map.size() == k && !map.containsKey(c)) {
                if (i - m > maxLen) {
                    maxLen = i - m;
                    maxSubstring = s.substring(m, i);
                }

                int leftMost = s.length();
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < leftMost) {
                        leftMost = entry.getValue();
                    }
                }

                m = leftMost + 1;
                map.remove(s.charAt(leftMost));
            }

            map.put(c, i);
        }

        if (map.size() == k && maxLen == 0) {
            return s;
        }

        return maxSubstring;
    }

    public static String maxSubStringKUniqueChars(String s, int k) {
        //declare a counter
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int maxLen = 0;
        String maxSubstring = null;

        for (int i = 0; i < s.length(); i++) {
            //add each char to the counter
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }

            if(map.size() == k+1){
                //get maximum
                int range = i-start;
                if(range > maxLen){
                    maxLen = range;
                    maxSubstring = s.substring(start, i);
                }

                //move left cursor toward right, so that substring contains only k chars
                char first = s.charAt(start);
                while(map.size()>k){
                    int count = map.get(first);
                    if(count>1){
                        map.put(first,count-1);
                    }else{
                        map.remove(first);
                    }
                    start++;
                }
            }
        }

        if (map.size() == k && maxLen == 0) {
            return s;
        }

        return maxSubstring;
    }


}
