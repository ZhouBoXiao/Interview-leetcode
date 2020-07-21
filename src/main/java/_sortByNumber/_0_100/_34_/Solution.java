package _sortByNumber._0_100._34_;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/20 13:59
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums,target), rightBound(nums,target)};
    }
    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] >= target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (left >= nums.length || nums[left] != target) return -1;
        return left;
    }
    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (right < 0 || nums[right] != target) return -1;
        return right;
    }
}
