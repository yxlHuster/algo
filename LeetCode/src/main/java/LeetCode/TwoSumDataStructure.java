package LeetCode;

/**
 * Created by allen on 6/11/15.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 */

public class TwoSumDataStructure {

    private Map<Integer, Integer> mps = new HashMap<Integer, Integer>();

    public void add(int number) {
        if (mps.containsKey(number)) {
            mps.put(number, mps.get(number) + 1);
        } else {
            mps.put(number, 1);
        }

    }

    public boolean find(int value) {
        for (Integer k : mps.keySet()) {
            int target = value - k;
            if (mps.containsKey(target)) {
                if (target == k && mps.get(target) < 2) continue;
                return true;
            }
        }
        return false;
    }

}
