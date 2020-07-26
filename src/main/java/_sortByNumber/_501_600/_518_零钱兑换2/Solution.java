package _sortByNumber._501_600._518_零钱兑换2;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/25 18:19
 */
public class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int c : coins) {
            for (int j = c ; j <= amount; j++) {
                dp[j] += dp[j-c];
            }
        }
        return dp[amount];
    }
}