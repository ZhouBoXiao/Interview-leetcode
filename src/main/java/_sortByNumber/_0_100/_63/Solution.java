package _sortByNumber._0_100._63;

public class Solution {
    /*
        dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 && j == 0)   dp[i][j] = 1;
                    else if (i == 0)    dp[i][j] = dp[i][j-1];
                    else if (j == 0)    dp[i][j] = dp[i-1][j];
                    else    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}