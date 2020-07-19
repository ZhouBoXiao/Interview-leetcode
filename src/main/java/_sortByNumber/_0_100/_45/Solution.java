package _sortByNumber._0_100._45;


/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int res = 0;
        int max = nums[0];
        int end = 0;
        for (int i = 0; i < nums.length ; i++) {

            max = Math.max(max, i + nums[i]);
            if (max >= nums.length-1)   return res+1;
            if (i == end) {
                res++;
                end = max;
            }

        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new Solution().jump(nums));
    }
}
