package LeetCode;

/**
 * Created by allen on 6/12/15.
 */
public class RotateArray {

    /**
     *
     * Can we do this in O(1) space and in O(n) time? The following solution does.

     Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:

     1. Divide the array two parts: 1,2,3,4 and 5, 6
     2. Rotate first part: 4,3,2,1,5,6
     3. Rotate second part: 4,3,2,1,6,5
     4. Rotate the whole array: 5,6,1,2,3,4
     * @param arr
     * @param order
     */
    public static void rotate(int[] arr, int order) {
        order = order % arr.length;

        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        //length of first part
        int a = arr.length - order;

        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length-1);
        reverse(arr, 0, arr.length-1);

    }

    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
