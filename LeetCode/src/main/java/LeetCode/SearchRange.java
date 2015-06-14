package LeetCode;

/**
 * Created by allen on 6/12/15.
 */

/**
 *
 * http://www.programcreek.com/2014/04/leetcode-search-for-a-range-java/
 */

/**
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value. Your algorithm's runtime complexity must be in the order of O(log n). If the target is not found in the array, return [-1, -1]. For example, given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 *
 */
public class SearchRange {


    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        binarySearch(arr, 0, nums.length - 1, target, nums);
        return arr;
    }

    public void binarySearch(int[] result, int left, int right, int target, int[] nums) {
        if (left > right) return;
        if (nums[left] == nums[right] && nums[left] == target) {
            result[0] = left;
            result[1] = left;
            return;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] > target) {
            binarySearch(result, left, mid - 1, target, nums);
        } else if (nums[mid] < target) {
            binarySearch(result, mid + 1, right, target, nums);
        } else {
            result[0] = mid;
            result[1] = mid;
            int i = mid;
            while (i > left && nums[i] == nums[i-1]) {
                i--;
                result[0] = i;
            }
            int j = mid;
            while (j < right && nums[j] == nums[j + 1]) {
                j++;
                result[1] = j;
            }
            return;
        }

    }

}
