package _sortByNumber._0_100._33_搜索旋转排序数组;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/20 13:28
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)  {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        // 寻找大于num[0]的右边界， 即为分界线
        while (left <= right) {
            int mid = left +  (right - left)/2;
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (target >= nums[0]) {
            left = 0;
        } else {
            left = right + 1;
            right = nums.length - 1;
        }
        // 寻找的左边界，即答案
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;

    }
}
