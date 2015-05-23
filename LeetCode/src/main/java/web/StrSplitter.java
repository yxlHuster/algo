package web;

/**
 * Created by allen on 5/3/15.
 */


/**
 *  对字符串切分，判断是否切分后，使得前后两段字符串等于某值，和不等于某值的个数相等！
 *  如果存在，返回切分的INDEX编号；
 *  如果不存在，返回 -1
 *  [5,5,1,7,2,3,5] return 4
 */
public class StrSplitter {

    public int soluation(int x, int[] array) {
        int start = 0;
        int end = array.length - 1;
        int countSame = 0;
        int countNotSame = 0;
        while (start < end) {
            if (array[start] == x) countSame++;
            if (array[end] != x) countNotSame++;
            if (countSame > countNotSame) {
                countSame--;
                start--;
            }
            if (countSame < countNotSame) {
                countNotSame--;
                end++;
            }
            start++;
            end--;
            System.out.println(start + "\t" + end + "\t" + countSame + "\t" + countNotSame);
        }
        if (start == end) {
            if( countSame == countNotSame + 1 && array[start] != x ) return start;
            else if( countSame == countNotSame - 1 && array[start] == x ) return start + 1;
            else if( countSame == countNotSame && array[start] == x ) return start - 1;
            else if( countSame == countNotSame && array[start] != x ) return start + 1;
            else return -1;
        } else {
            if (countSame == countNotSame) return start;
            return -1;
        }
    }


    public static void main(String[] args) {
        StrSplitter strSplitter = new StrSplitter();
        int x = 5;
        int[] array = {5,5,1,7,2,3,5};
        System.out.println(strSplitter.soluation(x, array));
    }
}
