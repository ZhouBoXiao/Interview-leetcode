package _剑指offer._按摩师;

public class Solution {
    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[][] dp  = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {

            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
//        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,4,5,3,1,1,3};
        new Solution().massage(nums);
    }
}
