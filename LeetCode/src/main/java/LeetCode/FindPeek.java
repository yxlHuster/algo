package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 上午10:41
 * To change this template use File | Settings | File Templates.
 */

/**
 * http://www.programcreek.com/2014/02/leetcode-find-peak-element/
 * A peak element is an element that is greater than its neighbors. Given an input array where num[i] ≠ num[i+1], find a peak element and return its index. The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that num[-1] = num[n] = -∞. For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 * Thoughts

 * This is a very simple problem. We can scan the array and find any element that is greater can its previous and next. The first and last element are handled separately.

 */
public class FindPeek {

    public int findPeakElement(int[] num) {
        int max = num[0];
        int index = 0;
        for(int i=1; i<=num.length-2; i++){
            int prev = num[i-1];
            int curr = num[i];
            int next = num[i+1];

            if(curr > prev && curr > next && curr > max){
                index = i;   // should return here
                max = curr;
            }
        }

        if(num[num.length-1] > max){
            return num.length-1;
        }

        return index;
    }

}
