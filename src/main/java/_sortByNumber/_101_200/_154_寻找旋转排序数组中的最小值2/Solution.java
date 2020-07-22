package _sortByNumber._101_200._154_寻找旋转排序数组中的最小值2;

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

    public int minArray(int[] nums) {
        int n = nums.length - 1;
        if (n < 0) return -1;
        while (n > 0 && nums[n] == nums[0]) n -- ;
        if (nums[n] >= nums[0]) return nums[0];
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;       // [l, mid], [mid + 1, r]
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[r];
    }
}
