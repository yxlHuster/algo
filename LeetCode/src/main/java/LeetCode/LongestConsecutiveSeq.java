package LeetCode;

/**
 * Created by author on 6/6/15.
 */


import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence
 * should be [1, 2, 3, 4]. Its length is 4.
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSeq {

    public static int longestConsecutive(int[] num) {
        Set<Integer> sets = new HashSet<Integer>();
        for (Integer n : num) {
            sets.add(n);
        }

        int max = 1;
        for (int i = 0; i < num.length; i++) {
            int len = 1;
            int curr = num[i];
            sets.add(curr);
            while (true) {
                curr++;
                if (!sets.contains(curr)) break;
                len++;
            }
            curr = num[i];
            while (true) {
                curr--;
                if (!sets.contains(curr)) break;
                len++;
            }
            if (len > max) max = len;
        }
        return max;
    }


    /**
     * After an element is checked, it should be removed from the set. Otherwise, time complexity would be O(mn) in which m is the average length of all consecutive sequences.
     * To clearly see the time complexity, I suggest you use some simple examples and manually execute the program. For example, given an array {1,2,4,5,3}, the program time is m. m is the length of longest consecutive sequence.
     * We do have an extreme case here: If n is number of elements, m is average length of consecutive sequence, and m==n, then the time complexity is O(n^2). The reason is that in this case, no element is removed from the set each time. You can use this array to get the point: {1,3,5,7,9}.
     * @param num
     * @return
     */
    public static int longestConsecutive2(int[] num) {
        Set<Integer> sets = new HashSet<Integer>();
        for (Integer n : num) {
            sets.add(n);
        }
        int max = 1;
        for (Integer n : num) {
            int count = 1;
            int left = n - 1;
            int right = n + 1;
            while (sets.contains(left)) {
                count++;
                sets.remove(left); // why remove
                left--;
            }
            while (sets.contains(right)) {
                count++;
                sets.remove(right); // why remove
                right++;
            }
            max = Math.max(max, count);
        }

        return max;
    }


    public static void main(String[] args) {
        int[] num = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(num));
    }

}
