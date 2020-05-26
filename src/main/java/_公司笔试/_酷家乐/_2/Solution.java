package _公司笔试._酷家乐._2;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/26 17:31
 */
public class Solution {
    public int solve(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - 1, right = i+1;
            while (right < nums.length && nums[right] > nums[i] ) right++;
            while (left >= 0 && nums[left] > nums[i] ) left--;
            max = Math.max(max, (right - left - 1) * nums[i]);
        }
        return max;
    }
}
