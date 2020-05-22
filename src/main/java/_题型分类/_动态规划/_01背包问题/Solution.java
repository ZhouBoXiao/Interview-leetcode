package _题型分类._动态规划._01背包问题;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/19 14:18
 */
public class Solution {
    int n, W;
    int[] w,v;
    int rec(int i, int j) {  /// rec(0, W)
        int res;
        if (i == n) {
            res = 0;
        } else if (j < w[i]) {
            res = rec(i+1, j);
        } else {
            res = Math.max(rec(i+1, j), rec(i+1, j - w[i]) + v[i]);
        }
        return res;
    }
    int MAX_N = 100000;
    int[][] dp; //记忆化数组
    int rec1(int i, int j) {
        if (dp[i][j] >= 0 ) {
            return dp[i][j];
        }
        int res;
        if (i == n) {
            res = 0;
        } else if (j < w[i]) {
            res = rec(i+1, j);
        } else {
            res = Math.max(rec(i+1, j), rec(i+1, j-w[i])+v[i]);
        }
        return dp[i][j] = res;
    }

    void solve3() {
        for (int i =  0; i < n ; i++) {
            for (int j = 0; j <= W ; j++) {
                if (j < w[i]) {
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }

}
