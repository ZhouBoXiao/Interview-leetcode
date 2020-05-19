package _sortByNumber._101_200._123;

public class Solution {

    /*
     状态转移方程
      dp[i][k][0] = max (dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
      dp[i][k][1] = max (dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);

      base case: dp[i][0][0] = 0
      dp[i][0][1] = -infinity
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[][][] dp = new int[prices.length][3][2];
        int manx = -1;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0] - prices[i], dp[i-1][j][1]);

            }
        }
        return dp[prices.length-1][2][0];

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(new Solution().maxProfit(nums));
    }
}
