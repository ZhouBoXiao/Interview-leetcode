package _201_300._287_寻找重复数;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/11 23:09
 */
public class Solution {
//    CountDownLatch latch = new CountDownLatch(1);

    public int findDuplicate2(int[] nums) {

        //暴力,固定每个数字,另外一个循环
        int fast = nums[nums[0]];
        int slow = nums[0];
        while(slow != fast){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        //找到了重合点,找入环点
        fast = 0;
        while(slow != fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
    public int findDuplicate(int[] nums) {

        int left = 1, right = nums.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
