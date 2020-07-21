package _题型分类._动态规划._64_最小路径和;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/21 22:02
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m + 1];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum +=  grid[0][i];
            dp[i] = sum;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[j] +=  grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1];
    }
}
