package _题型分类._动态规划._完全背包;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/19 15:48
 */

public class Solution {
    int n,W;
    int[] w,v;

    int[][] dp;
    void solve2() {
        for (int i =  0; i < n ; i++) {
            for (int j = 0; j <= W ; j++) {
                if (j < w[i]) {
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i+1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}
