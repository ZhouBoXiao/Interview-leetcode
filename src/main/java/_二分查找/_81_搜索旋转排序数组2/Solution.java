package _二分查找._81_搜索旋转排序数组2;

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int left = 0 , right = nums.length - 1;
        while (left <= right) {
            while (left<right && nums[left] == nums[left+1]) left++;
            while (left<right && nums[right] == nums[right-1]) right--;
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid]  < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            } else if (nums[mid] >= nums[right]){
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{2,5,6,0,0,1,2}, 0));
    }
}
/**
 [1,1,3,1]
 3*/