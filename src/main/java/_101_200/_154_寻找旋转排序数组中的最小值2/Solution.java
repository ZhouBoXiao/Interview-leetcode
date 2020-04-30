package _101_200._154_寻找旋转排序数组中的最小值2;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 16:13
 */
public class Solution {
    public int findMin(int[] nums) {
        int l = 0 , r= nums.length - 1;
        while (l < r) {
            int mid  = l + (r - l) /2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}
