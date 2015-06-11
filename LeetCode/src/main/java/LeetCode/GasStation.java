package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-11
 * Time: 下午3:28
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 *  http://www.programcreek.com/2014/03/leetcode-gas-station-java/
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;
        for(int i = 0; i < gas.length; i++) {
            int remaining = gas[i] - cost[i];

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
            //otherwise, reset start index to be current
            } else {
                start = i;
                sumRemaining = remaining;
            }
            total += remaining;
        }
        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    }
