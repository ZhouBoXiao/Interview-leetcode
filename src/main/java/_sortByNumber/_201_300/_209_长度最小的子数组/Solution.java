package _sortByNumber._201_300._209_长度最小的子数组;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/19 16:09
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }
}
