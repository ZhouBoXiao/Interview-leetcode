package _公司笔试.leetcode._第25场双周赛._4;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/2 22:31
 * 总共有 n 个人和 40 种不同的帽子，帽子编号从 1 到 40 。
 *
 * 给你一个整数列表的列表 hats ，其中 hats[i] 是第 i 个人所有喜欢帽子的列表。
 *
 * 请你给每个人安排一顶他喜欢的帽子，确保每个人戴的帽子跟别人都不一样，并返回方案数。
 *
 * 由于答案可能很大，请返回它对 10^9 + 7 取余后的结果。
 */
public class Solution {
    /**
     * dp[i][j]  前i个帽子，n个人的状态为j时的方案数。
     * 状态j的具体含义：如果j=1023，即2进制为1111111111时，所有人都戴着帽子，相反j=0时，所有人都没戴帽子。
     * 接下来要考虑的是状态转移，对于dp[i][j]，有以下两种情况：
     * dp[i - 1][j]：帽子i根本没被用到
     * dp[i - 1][j xor k]：帽子被用到（k为二进制只有1位为一的整数，且j & k != 0，且该位表示的匹配符合该人的喜好
     * 把以上两种情况（最多1 + 10种转移）全加在一起，就可以得到dp[i][j]了。
     * 最后dp[-1][-1]就是我们要的方案数。
     *
     */
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        boolean[][] valid = new boolean[50][n];
        for (int i = 0; i < n; ++i) {
            for (int h : hats.get(i)) {
                valid[h][i] = true;
            }
        }
        int mod = 1000000007;
        int m = (1 << n);
        int[][] dp = new int[50][m];
        dp[0][0] = 1;
        for (int i = 1; i <= 40; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                for (int k = 0; k < n; ++k) {
                    if ((j & (1 << k)) != 0 && valid[i][k]) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j ^ (1 << k)]) % mod;
                    }
                }
            }
        }
        return dp[40][m - 1];
    }

    public static void main(String[] args) {
        List<List<Integer>> hats = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(3);
            tmp.add(4);
        }
        System.out.println(new Solution());
    }
}
