package _sortByNumber._0_100._16_最接近的三数之和;

import java.util.Arrays;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/5 13:30
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length -2; k++) {

            int i = k + 1, j = nums.length - 1;
            while (i < j ) {
                int sum  = nums[i] + nums[k] + nums[j];
                if (Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                }
                if (sum > target) {
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    return target;
                }

            }
        }
        return min;
    }
}
