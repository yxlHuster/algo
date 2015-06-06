package LeetCode;

/**
 * Created by allen on 6/6/15.
 */

/**
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.
 *
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 0 -> 0
 */
public class SearchInsertPos {

    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0 || A[0] >= target) return 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < target && A[i + 1] >= target) {
                return i + 1;
            }
        }
        return A.length;
    }


    public int searchInsert2(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        return searchInsert(A, target, 0, A.length -1);
    }
    public int searchInsert(int[] A, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (A[mid] == target) return mid;
        else if (A[mid] > target) {
            return start < mid ? searchInsert(A, target, start, mid - 1):start;
        } else {
            return end > mid ? searchInsert(A, target, mid + 1, end):(end + 1);
        }
    }
}
