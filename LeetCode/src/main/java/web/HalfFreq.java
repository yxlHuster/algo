package web;

/**
 * Created by allen on 5/10/15.
 *
 *
 * http://blog.csdn.net/zhangerqing/article/details/8138296
 */
public class HalfFreq {


    public int findMoreThanHalf(int[] array) {
        int freq = 0;
        int start = -1;
        for (int i = 0; i < array.length; i++) {
            if (freq == 0) {
                start = array[i];
                freq++;
            } else {
                if (start != array[i]) {
                    freq--;
                } else {
                    freq++;
                }
            }
        }
        return start;
    }

    public static void main(String[] args) {
        HalfFreq halfFreq = new HalfFreq();
        int[] array = {2,3,2,2,1,4,2,2,2,7,9,6,2,2,3,1};
        System.out.println(halfFreq.findMoreThanHalf(array));
    }
}
