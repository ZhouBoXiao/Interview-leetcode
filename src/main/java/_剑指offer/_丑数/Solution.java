package _剑指offer._丑数;

import java.util.PriorityQueue;

public class Solution {
    public int nthUglyNumber(int n) {

        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0, index3 = 0, index5= 0;
        for (int i = 1; i <nums.length; i++) {
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if (nums[i] == nums[index2] * 2) index2++;
            if (nums[i] == nums[index3] * 3) index3++;
            if (nums[i] == nums[index5] * 5) index5++;

        }
        return nums[n-1];

    }

    public static void main(String[] args) {
        new Solution().nthUglyNumber(12);
    }
}
