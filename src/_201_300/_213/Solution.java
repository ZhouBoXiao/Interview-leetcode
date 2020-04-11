package _201_300._213;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums,0,n-2), robRange(nums,1,n-1));
    }
    // 仅计算闭区间 [start,end] 的最优结果
    int robRange(int[] nums, int start, int end) {

        int dpi = 0,dpi1=0,dpi2=0;

        for (int i = end; i >= start; i--) {

            dpi = Math.max(dpi1, dpi2 + nums[i]);
            dpi2 = dpi1;
            dpi1 = dpi;
        }

        return dpi;
    }
}
