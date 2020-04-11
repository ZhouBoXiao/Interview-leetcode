package _201_300._239;

import java.util.*;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length < 2) return nums;

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i - k + 1 > queue.peekFirst()) {
                queue.removeFirst();
            }
            if (i - k + 1 >= 0) {
                result[i-k+1] = nums[queue.peekFirst()];
            }


        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};

        new Solution().maxSlidingWindow(nums, 3);
    }


}
