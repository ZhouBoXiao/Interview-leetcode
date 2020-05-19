package _sortByNumber._201_300._239;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 */
public class Solution {

    public int[] maxSlidingWindow1(int[] nums, int k) {
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

    /**
     * 特殊数据结构：单调队列
     */
    private class MonotonicQueue {
        private Deque<Integer> queue = new LinkedList<>();

        void push(int n) {
            while (!queue.isEmpty() && queue.peekLast() < n) {
                queue.pollLast();
            }
            queue.offerLast(n);
        }
        int max() {
            return queue.peekFirst();
        }
        void pop(int n) {

            if (!queue.isEmpty() && queue.peekFirst() == n) {
                queue.pollFirst();
            }
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length < 2) return nums;
        MonotonicQueue queue = new MonotonicQueue();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i < k -1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                result[i - k + 1] = queue.max();
                queue.push(nums[i - k + 1]);
            }

        }
        return result;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};

        new Solution().maxSlidingWindow(nums, 3);
    }


}
