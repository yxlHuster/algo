package LeetCode;

/**
 * Created by allen on 5/18/15.
 */
public class MaxSubArray {


    public int maxSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int pos = -1;
        for (int i = 0; i < array.length; i++) {
            sum = Math.max(sum + array[i], array[i]);
            if (max < sum) {
                max = sum;
                pos = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray.maxSubArray(array));
    }
}
