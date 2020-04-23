package _剑指offer._礼物的最大价值;

public class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int []dp = new int[n];
        for (int i = 0; i < m; i ++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n ; j++) {
                dp[j] = Math.max(dp[j-1], dp[j]) + grid[i][j];
            }
        }
        return dp[n-1];
    }
}
