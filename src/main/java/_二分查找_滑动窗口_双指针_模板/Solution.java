package _二分查找_滑动窗口_双指针_模板;

public class Solution {
    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}
/**
 * 回溯算法
 *
 result = []
 def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
    return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
 *
 */


/**
 * 滑动窗口
 *
 int left = 0, right = 0;

 while (right < s.size()) {
     window.add(s[right]);
     right++;

     while (valid) {
         window.remove(s[left]);
         left++;
     }
 }
 */