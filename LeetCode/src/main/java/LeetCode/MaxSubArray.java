package LeetCode;

/**
 * Created by allen on 5/18/15.
 */
public class MaxSubArray {


    public int maxSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = Math.max(sum + array[i], array[i]);
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] array) {
        int start = 0;
        int end = 0;
        int p = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
                p = i;
            } else {
                sum += array[i];
            }
            if (sum > max) {
                max = sum;
                start = p;
                end = i;
            }
        }
        return max;
    }

    public int maxSubArray3(int[] array) {
        int len = array.length;
        int max = array[0];
        int[] sum = new int[len];
        sum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            sum[i] = Math.max(sum[i - 1], array[i] + sum[i - 1]);
            max = Math.max(sum[i], max);
        }
        return max;
    }

    public int maxSubArray4(int[] array) {
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = Math.max(array[i], sum + array[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray.maxSubArray(array));
    }
}
