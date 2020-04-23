package _剑指offer._股票的最大利润;

public class Solution {
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] res = new int[2];
        int n = prices.length;
        res[0] = -prices[0];
        for (int i = 1 ; i < n; i++) {
            res[0] = Math.max(res[0] , - prices[i]);
            res[1] = Math.max(res[1] , prices[i] + res[0]);
        }
        return res[1];
    }
        /**
     状态转移方程
      dp[i][k][0] = max (dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
      dp[i][k][1] = max (dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);

      base case: dp[i][0][0] = 0
      dp[i][0][1] = -infinity
     */
    public int maxProfit(int k, int[] prices) {
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

    public static void main(String[] args) {
        int[] prices = new int[]{
                3,3,5,0,0,3,1,4
        };
        new Solution().maxProfit(2, prices);
    }
}
