package LeetCode;

import java.util.Stack;

/**
 * Created by allen on 5/28/15.
 */
public class ReversePolishNotation {



    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        String operations = "+-*/";
        int returnValue = 0;
        Stack<String> number = new Stack<String>();
        for (String token : tokens) {
            if (!operations.contains(token)) {
                number.push(token);
            } else {
                int index = operations.indexOf(token);
                int a = Integer.valueOf(number.pop());
                int b = Integer.valueOf(number.pop());
                switch (index) {
                    case 0:
                        number.push(String.valueOf(a + b));
                        break;
                    case 1:
                        number.push(String.valueOf(b - a));
                        break;
                    case 2:
                        number.push(String.valueOf(a * b));
                        break;
                    case 3:
                        number.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        if (!number.isEmpty()) {
            returnValue = Integer.valueOf(number.pop());
        }
        return returnValue;
    }
}
