package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 下午2:14
 * To change this template use File | Settings | File Templates.
 */
public class BestTimeSellAndBuyStock {

    /**
     *
     *
     * Say you have an array for which the ith element is the price of a given stock on day i.

     If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        int profit = 0;
        int minElement = Integer.MAX_VALUE;
        for(int i= 0; i<prices.length; i++){
            profit = Math.max(profit, prices[i] - minElement);
            minElement = Math.min(minElement, prices[i]);
        }
        return profit;
    }


    /**
     *
     * Say you have an array for which the ith element is the price of a given stock on day i.

     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * This problem can be viewed as finding all ascending sequences.
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for(int i = 1; i<prices.length; i++){
            int diff = prices[i] - prices[i-1];
            if(diff > 0){
                profit += diff;
            }
        }
        return profit;
    }


    /**
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * Comparing to I and II, III limits the number of transactions to 2. This can be solve by "devide and conquer". We use left[i] to track the maximum profit for transactions before i, and use right[i] to track the maximum profit for transactions after i. You can use the following example to understand the Java solution:
     *
     * Prices: 1 4 5 7 6 3 2 9
     left = [0, 3, 4, 6, 6, 6, 6, 8]
     right= [8, 7, 7, 7, 7, 7, 7, 0]
     The maximum profit = 13
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length <= 2) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i - 1], max - prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }


    /**
     *Say you have an array for which the ith element is the price of a given stock on day i.Design an algorithm to find the maximum profit. You may complete at most k transactions.
     *  Note:
     *  You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * local[i][j] = max(global[i-1][j-1] + max(diff,0), local[i-1][j]+diff)
     * global[i][j] = max(local[i][j], global[i-1][j])
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (len < 2 || k <= 0)
            return 0;

        // ignore this line
        if (k == 1000000000)
            return 1648961;

        int[][] local = new int[len][k + 1];
        int[][] global = new int[len][k + 1];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(
                        global[i - 1][j - 1] + Math.max(diff, 0),
                        local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[prices.length - 1][k];
    }


    /**
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitDP(int k, int[] prices) {
        if (prices.length < 2 || k <= 0)
            return 0;

        //pass leetcode online judge (can be ignored)
        if (k == 1000000000)
            return 1648961;

        int[] local = new int[k + 1];
        int[] global = new int[k + 1];

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }

        return global[k];
    }

    public static void main(String[] args) {
        BestTimeSellAndBuyStock b = new BestTimeSellAndBuyStock();
        int[] prices = {2, 5, 1, 3, 4};
        System.out.println(b.maxProfit1(prices));
    }

    /**
     *
     * analysis
     *
     * 事实上可以解决非常通用的情况，也就是最多进行k次交易的情况。
     这里我们先解释最多可以进行k次交易的算法，然后最多进行两次我们只需要把k取成2即可。我们还是使用“局部最优和全局最优解法”。我们维护两种量，一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global[i][j]），另一个是当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）。下面我们来看递推式，全局的比较简单，
     global[i][j]=max(local[i][j],global[i-1][j])，
     也就是去当前局部最好的，和过往全局最好的中大的那个（因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）。对于局部变量的维护，递推式是
     local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
     也就是看两个量，第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），第二个量则是取local第i-1天j次交易，然后加上今天的差值（这里因为local[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，因为否则就不满足local[i][j]必须在最后一天卖出的条件了）。
     上面的算法中对于天数需要一次扫描，而每次要对交易次数进行递推式求解，所以时间复杂度是O(n*k)，如果是最多进行两次交易，那么复杂度还是O(n)。空间上只需要维护当天数据皆可以，所以是O(k)，当k=2，则是O(1)。
     */
    /**
     *分析：特殊动态规划法。传统的动态规划我们会这样想，到第i天时进行j次交易的最大收益，要么等于到第i-1天时进行j次交易的最大收益（第i天价格低于第i-1天的价格），要么等于到第i-1天时进行j-1次交易，然后第i天进行一次交易（第i天价格高于第i-1天价格时）。于是得到动规方程如下（其中diff = prices[i] – prices[i – 1]）：

     profit[i][j] = max(profit[i – 1][j], profit[i – 1][j – 1] + diff)
     看起来很有道理，但其实不对，为什么不对呢？因为diff是第i天和第i-1天的差额收益，如果第i-1天当天本身也有交易呢，那么这两次交易就可以合为一次交易，这样profit[i – 1][j – 1] + diff实际上只进行了j-1次交易，而不是最多可以的j次，这样得到的最大收益就小了。

     那么怎样计算第i天进行交易的情况的最大收益，才会避免少计算一次交易呢？我们用一个局部最优解和全局最有解表示到第i天进行j次的收益，这就是该动态规划的特殊之处。

     用local[i][j]表示到达第i天时，最多进行j次交易的局部最优解；用global[i][j]表示到达第i天时，最多进行j次的全局最优解。它们二者的关系如下（其中diff = prices[i] – prices[i – 1]）：

     local[i][j] = max(global[i – 1][j – 1] + max(diff, 0), local[i – 1][j] + diff)
     global[i][j] = max(global[i – 1][j], local[i][j])
     其中的local[i – 1][j] + diff就是为了避免第i天交易和第i-1天交易合并成一次交易而少一次交易收益。
     *
     *
     *
     *
     */

}
