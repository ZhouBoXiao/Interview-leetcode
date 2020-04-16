package _101_200._198;

public class Solution {
    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        System.arraycopy(nums,0 ,dp, 0,nums.length);

        for (int i = 1; i < nums.length; i++) {
            if (i > 1)
                dp[i] =  Math.max(dp[i-1], dp[i-2] + nums[i]);
            else
                dp[i] = Math.max(dp[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(new Solution().rob(nums));
    }
}
