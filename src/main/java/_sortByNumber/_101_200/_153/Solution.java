package _sortByNumber._101_200._153;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 15:43
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        int left  = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else{
                left = mid +1;
            }
        }
        return nums[left];
    }
}
