package _剑指offer._滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/14 10:51
 */
public class Solution {
    public int[] maxSlidingWindow1(int[] nums, int k) {

        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0, j = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }
        return res;
    }
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < size; i++)
            heap.add(num[i]);

        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

}
