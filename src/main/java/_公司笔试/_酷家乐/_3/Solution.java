package _公司笔试._酷家乐._3;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/26 17:31
 */
public class Solution {
    public boolean solve(int[][] nums, int target) {
        if (nums.length == 0 || nums[0].length == 0) {
            return false;
        }
        int n = nums.length;
        int m = nums[0].length;
        for (int i = 0, j = m - 1; j >= 0 && i < n ;) {
            if (nums[i][j] == target) {
                return true;
            } else if (nums[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
