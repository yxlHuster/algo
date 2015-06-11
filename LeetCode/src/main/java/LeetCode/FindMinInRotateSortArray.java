package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 上午11:33
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.You may assume no duplicate exists in the array.
 */

/**
 *
 * This problems seems like a binary search, and the key is how to break the array to two parts, so that we only need to work on half of the array each time, i.e., when to select the left half and when to select the right half.

 If we pick the middle element, we can compare the middle element with the left-end element. If middle is less than leftmost, the left half should be selected; if the middle is greater than the leftmost, the right half should be selected. Using simple recursion, this problem can be solve in time log(n).

 In addition, in any rotated sorted array, the rightmost element should be less than the left-most element, otherwise, the sorted array is not rotated and we can simply pick the leftmost element as the minimum.
 */
public class FindMinInRotateSortArray {


    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }

    public int findMin(int[] num, int left, int right) {
        if (left == right)
            return num[left];
        if ((right - left) == 1)
            return Math.min(num[left], num[right]);

        int middle = left + (right - left) / 2;

        // not rotated
        if (num[left] < num[right]) {
            return num[left];

            // go right side
        } else if (num[middle] > num[left]) {
            return findMin(num, middle, right);

            // go left side
        } else {
            return findMin(num, left, middle);
        }
    }


    /**
     * This is a follow-up problem of finding minimum element in rotated sorted array without duplicate elements. We only need to add one more condition, which checks if the left-most element and the right-most element are equal. If they are we can simply drop one of them. In my solution below, I drop the left element whenever the left-most equals to the right
     * @param num
     * @param left
     * @param right
     * @return
     */
    public int findMinWithDup(int[] num, int left, int right) {
        if (left == right) return num[left];
        if (right - left == 1) return Math.min(num[left], num[right]);

        int mid = left + (right - left) / 2;
        // 3 3 1 3 3 3
        if (num[left] < num[right]) {
            return num[left];
        } else if (num[left] == num[right]) {
            return findMin(num, left + 1, right);
        } else if (num[mid] >= num[left]) {
            return findMin(num, mid, right);
        } else {
            return findMin(num, left, mid);
        }

    }

}
