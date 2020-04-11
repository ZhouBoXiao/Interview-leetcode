package _201_300._300;

public class Solution {
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {

            int left = 0, right = len;

            while (left < right) {
                int mid = (left + right)/2;
                if (nums[i] > dp[mid]) {
                    left = mid + 1;
                } else{
                    right = mid;
                }

            }

            dp[left] = nums[i];
            if (left == len) {
                len++;
            }
        }
        return len;

    }

    public static void main(String[] args) {
        //10,9,2,5,3,7,101,18

        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
