package LeetCode;

/**
 * Created by allen on 6/6/15.
 */

import java.util.Stack;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {


    public boolean isPalindrome1(String s) {
        if (s == null || s.length() < 2) return true;
        int len = s.length();
        char[] array = s.toCharArray();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            char left, right;
            while (i < len - 1 && !isAlpha(array[i]) && !isNum(array[i])) {
                i++;
                left = array[i];
            }
            while (j > 0 && !isAlpha(array[j]) && !isNum(array[j])) {
                j--;
                right = array[j];
            }
            if (i >= j) break;
            left = array[i];
            right = array[j];
            if (!isSame(left, right)) return false;
            i++;
            j--;
        }
        return true;
    }

    public  boolean isAlpha(char a){
        if((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')){
            return true;
        }else{
            return false;
        }
    }

    public  boolean isNum(char a){
        if(a >= '0' && a <= '9'){
            return true;
        }else{
            return false;
        }
    }

    public  boolean isSame(char a, char b){
        if(isNum(a) && isNum(b)){
            return a == b;
        }else if(Character.toLowerCase(a) == Character.toLowerCase(b)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isPalindrome2(String s) {
        if (s == null || s.length() < 2) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        int index = 0;
        while (index < len / 2) {
            stack.push(s.charAt(index));
            index++;
        }
        if (len % 2 == 1) index++;
        while (index < len) {
            if (stack.isEmpty()) return false;
            char temp = stack.pop();
            if (temp != s.charAt(index)) return false;
            index++;
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    public boolean isPalindrome3(String s) {
        if (s == null || s.length() < 2) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";

        System.out.println(s.replaceAll("[^a-zA-Z0-9]", ""));
    }

}
