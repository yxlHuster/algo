package LeetCode;

/**
 * Created by allen on 6/11/15.
 */

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 *
 *
 */
public class HouseRobber {

    /**
     *
     * dp[i] = max (dp[i-1](not rob i), dp[i-2] + num[i] (rob i))
     * @param num
     * @return
     */
    public int rob(int[] num) {
        if (num == null || num.length == 0) return 0;
        int[] dp = new int[num.length + 1];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);
        for (int i = 2; i < num.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
        }
        return dp[num.length - 1];
    }

    /**
     *
     * @param num
     * @return
     */
    public int rob2(int[] num) {
        if(num==null || num.length==0)
            return 0;

        int n = num.length;

        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=num[0];

        for (int i=2; i<n+1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+num[i-1]);
        }

        return dp[n];
    }


    public int rob3(int[] num) {
        if(num==null || num.length == 0)
            return 0;

        int even = 0;
        int odd = 0;

        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                even += num[i];
                even = even > odd ? even : odd;
            } else {
                odd += num[i];
                odd = even > odd ? even : odd;
            }
        }

        return even > odd ? even : odd;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] a = {50, 1, 1, 150};
        System.out.println(houseRobber.rob(a));
        System.out.println(houseRobber.rob2(a));
        System.out.println(houseRobber.rob3(a));
    }
}
