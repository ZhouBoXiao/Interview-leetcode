package _剑指offer._和为s的两个数字;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 13:19
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0 ,r = nums.length - 1;
        while (l <= r) {
            int tmp = nums[l] + nums[r];
            if (target == tmp) {
                return new int[]{l,r};
            } else if (target > tmp){
                l++;
            } else {
                r--;
            }
        }
        return new int[0];
    }
}
