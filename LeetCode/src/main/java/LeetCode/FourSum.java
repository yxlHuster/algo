package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yongleixiao on 2015/3/18.
 */
public class FourSum {


    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                int start = j + 1;
                int end = num.length - 1;
                while (start < end) {
                    int sum = num[i] + num[j] + num[start] + num[end];
                    if (sum == target) {
                        List<Integer> ls = new ArrayList<Integer>();
                        ls.add(num[i]);
                        ls.add(num[j]);
                        ls.add(num[start]);
                        ls.add(num[end]);
                        results.add(ls);
                        start++;
                        end--;
                    } else if (sum > target) {
                        end --;
                    } else {
                        start++;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        FourSum fourSum = new FourSum();
        List<List<Integer>> nodes = fourSum.fourSum(nums, target);
        for(List<Integer> ls : nodes) {
            for (Integer i : ls) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}
