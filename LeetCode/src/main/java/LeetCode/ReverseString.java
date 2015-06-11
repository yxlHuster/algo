package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 上午10:08
 * To change this template use File | Settings | File Templates.
 */

/**
 * Given an input string, reverse the string word by word.

 For example, given s = "the sky is blue", return "blue is sky the".
 */

/**
 * This problem is pretty straightforward. We first split the string to words array, and then iterate through the array and add each element to a new string. Note: StringBuilder should be used to avoid creating too many Strings. If the string is very long, using String is not scalable since String is immutable and too many objects will be created and garbage collected.
 */
public class ReverseString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!(arr[i].equals(""))) sb.append(arr[i]).append(" ");
        }
        return sb.length() == 0 ? " " : sb.toString().substring(0, sb.length() - 1);
    }
}

