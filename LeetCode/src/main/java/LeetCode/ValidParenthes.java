package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by allen on 6/3/15.
 */
public class ValidParenthes {


    public static boolean isValid(String s) {
        Map<Character, Character> mps = new HashMap<Character, Character>();
        mps.put('{', '}');
        mps.put('[', ']');
        mps.put('(', ')');
        Stack<Character> stack = new Stack<Character>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (mps.containsKey(c)) {
                stack.push(c);
            } else if (mps.values().contains(c)){
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
