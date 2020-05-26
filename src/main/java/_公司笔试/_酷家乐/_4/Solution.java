package _公司笔试._酷家乐._4;

import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/26 17:31
 */
public class Solution {
    int cnt =0;
    int[] temp;
    public int  solve(List<String> list) {
        int n = list.size();
        int[] nums = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            String temp = list.get(i);

            if (temp.charAt(0) == 'C') {
                nums[i] = 10 + temp.charAt(1) - '0';
            } else if (temp.charAt(0) == 'D') {
                nums[i] = 20 + temp.charAt(1) - '0';
            } else if (temp.charAt(0) == 'B') {
                nums[i] = 30 + temp.charAt(1) - '0';
            }
        }

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i-1]) {
                cnt++;
                int index = rightBound(nums,  i , nums[i-1]);
                if (index >= n) {
                    index = n-1;
                }
                swap(nums, index, i-1);
                i = 0;
            }

        }
        return cnt;
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int rightBound(int[] nums, int left,  int target) {
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return right;
    }

}
