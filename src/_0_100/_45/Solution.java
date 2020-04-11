package _0_100._45;

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
