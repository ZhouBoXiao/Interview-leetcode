package _题型分类._动态规划._买卖股票1;

/**
 * @Description:
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * @Author:boxiao
 * @Data: 2020/5/2 10:09
 */
public class Solution {
    // 一次
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);

        }
        return max;
    }


    //尽可能地完成更多的交易
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }
        return dp_i_0;
    }

    // 买两笔
    public int maxProfit2(int[] prices) {
        int k = 2;
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1 ; j <= k ; j++) {
                if (i == 0) {
                    dp[i][j][1] = -prices[0];
                } else {
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                }

            }
        }
        return dp[n -1][k][0];
    }

    // 买k 笔
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        if (k > prices.length / 2)
            return maxProfit_k_inf(prices);
        int[][][] dp = new int[prices.length][k+1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0] - prices[i], dp[i-1][j][1]);

            }
        }
        return dp[prices.length-1][k][0];

    }

    private int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }
        return dp_i_0;
    }

}
