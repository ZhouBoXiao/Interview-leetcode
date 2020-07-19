package _题型分类._动态规划._完全背包;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/19 15:48
 */

public class Solution {
    int n,W;
    int[] w,v;

    int[] dp;
    // 0 1 背包
    void solve1() {
        for (int i =  0; i < n ; i++) {
            for (int j = W; j >= w[i] ; j--) {

                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[W]);
    }

    // 完全背包

    void solve2() {
        int m = 0;
        for (int i =  0; i < n ; i++) {
            for (int j = w[i]; j <= m ; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[W]);
    }


    // 多重背包
    void solve3() {
        int s = 0, m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j++) {
                for (int k = 1; k <= s && k * w[i] <= j ; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * w[i] ] + k * v[i] );
                }
            }
        }
        System.out.println(dp[m]);
    }
}
