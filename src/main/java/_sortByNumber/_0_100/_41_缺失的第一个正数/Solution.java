package _sortByNumber._0_100._41_缺失的第一个正数;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/27 12:08
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i+1)) {
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        new Solution().firstMissingPositive(new int[]{0,1,2});
    }
}
