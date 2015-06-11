package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */

/**
 * http://www.programcreek.com/2014/03/leetcode-maximum-gap-java/
 */
public class MaxGrap {

    class Bucket {
        int low;
        int high;
        public Bucket() {
            low = -1;
            high = -1;
        }
    }

    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) return 0;
        int max = num[0];
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }
        Bucket[] buckets = new Bucket[num.length + 1];
        for (int i = 0; i < num.length + 1; i++) {
            buckets[i] = new Bucket();
        }
        double interval = (double) num.length / (max - min);
        //distribute every number to a bucket array
        for (int i = 0; i < num.length; i++) {
            int index = (int)(interval * (num[i] - min));
            if (buckets[index].low == -1) {
                buckets[index].low = num[i];
                buckets[index].high = num[i];
            } else {
                buckets[index].low = Math.min(buckets[index].low, num[index]);
                buckets[index].high = Math.max(buckets[index].high, num[index]);
            }
        }

        //scan buckets to find maximum gap
        int result = 0;
        int prev = buckets[0].high;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].low != -1) {
                result = Math.max(buckets[i].low - prev, result);
                prev = buckets[i].high;
            }
        }
        return result;
    }
}
