package _600以上._746;


public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            if (i == n-1 && dp[i-1] < dp[i-2]+ cost[i]) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
            }
        }

        return dp[n-1];

    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }

}
