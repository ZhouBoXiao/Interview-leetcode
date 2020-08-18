package _sortByNumber._101_200._152_乘积最大子数组;

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

    public int maxProduct1(int[] nums) {
        int res = nums[0];
        int f = nums[0], g = nums[0];

        for (int i = 1 ;i < nums.length; i++) {
            int a = nums[i]; int  fa = f * a; int ga = g * a;
            f = Math.max(a , Math.max(fa, ga));
            g = Math.min(a, Math.min(fa, ga));
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,3,-4};
        System.out.println(new Solution().maxProduct(nums));
    }
}
