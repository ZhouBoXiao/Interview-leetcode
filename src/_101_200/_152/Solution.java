package _101_200._152;

import java.util.Arrays;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int imax = 1, imin = 1,max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            max = Math.max(max,imax);
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-2,3,-4};
        System.out.println(new Solution().maxProduct(nums));
    }
}
