package LeetCode;

/**
 * Created by allen on 6/12/15.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.

 For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 */
public class IsomorphicString {


    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        if (s.length() == t.length() && t.length() == 0) return true;

        Map<Character, Character> mps = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            Character c = getKey(mps, c2);
            if (c != null && c != c1) return false;
            else if(mps.containsKey(c1)){
                if(c2 != mps.get(c1))
                    return false;
            }else{
                mps.put(c1,c2);
            }
        }
        return true;

    }

    // a method for getting key of a target value
    public Character getKey(Map<Character,Character> map, Character target){
        for (Map.Entry<Character,Character> entry : map.entrySet()) {
            if (entry.getValue().equals(target)) {
                return entry.getKey();
            }
        }

        return null;
    }
}
