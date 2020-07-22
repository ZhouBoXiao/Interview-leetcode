package _题型分类._二分查找._275_H指数2;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/22 21:56
 */
public class Solution {
    public int hIndex(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[nums.length - mid - 1] > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int hIndex1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[n - mid] >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
