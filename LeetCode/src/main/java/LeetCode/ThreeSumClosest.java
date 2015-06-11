package LeetCode;


import java.util.Arrays;

/**
 * Created by author on 2015/3/18.
 */
public class ThreeSumClosest {


    public int threeSumClosest(int[] num, int target) {
        int sum = target;
        int df = Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int diff = num[i] + num[start] + num[end] - target;
                System.out.println(num[i] + ":" + num[start] + ":" + num[end] + ":" + diff);
                if (Math.abs(diff) < df) {
                    df = Math.abs(diff);
                    sum = num[i] + num[start] + num[end];
                }
                if (diff > 0) {
                    end--;
                } else if (diff < 0) {
                    start++;
                } else {
                    return target;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] num = {-4,-1,1,2};
        System.out.println(threeSumClosest.threeSumClosest(num, 1));
    }

}
