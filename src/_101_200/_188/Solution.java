package _101_200._188;

public class Solution {

    /*
     状态转移方程
      dp[i][k][0] = max (dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
      dp[i][k][1] = max (dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);

      base case: dp[i][0][0] = 0
      dp[i][0][1] = -infinity
     */
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

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,6,5,0,3};
        System.out.println(new Solution().maxProfit(2,nums));
    }
}
