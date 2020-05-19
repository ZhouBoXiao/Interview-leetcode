package _动态规划._状态压缩._旅行商问题;

import java.util.Arrays;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/8 13:46
 */
public class Solution {
    int MAX_N = 100000;
    int n;
    int[][] d = new int[MAX_N][MAX_N];
    int[][] dp = new int[1 << MAX_N][MAX_N];
    // 已经访问过的节点集合为S, 当前位置为v
    int rec(int S, int v) {
        if (dp[S][v] >= 0) {
            return dp[S][v];
        }
        if (S == (1 << n) - 1 && v == 0) {
            // 已经访问过所有节点并回到0号点
            return dp[S][v] = 0 ;
        }
        int res = Integer.MAX_VALUE;
        for (int u = 0; u < n; u++) {
            if ((S >> u & 1 ) == 0) {
                res = Math.min(res, rec(S | 1 << u, u) + d[v][u]);
            }
        }
        return dp[S][v] = res;
    }
    void solve() {
        Arrays.fill(dp, -1);
        System.out.println(rec(0, 0));
    }

    void solve1(){
        /**
         * dp[S][v] 表示从v出发访问剩余的所有顶点，最终回到顶点0的路径的权重总和的最小值。
         */
        for (int S = 0; S < 1 << n; S++) {
            Arrays.fill(dp[S], 0 ,n ,Integer.MAX_VALUE);
        }
        dp[ (1 << n) - 1][0] = 0;
        for (int S = (1 << n) - 2; S >=0 ; S--) {
            for (int v = 0; v < n; v++) {
                for (int u = 0; u < v; u++) {
                    if ( (S >> u &  1) == 0) {
                        dp[S][v] = Math.min(dp[S][v], dp[S | 1<<u][u] + d[v][u]);
                    }
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
