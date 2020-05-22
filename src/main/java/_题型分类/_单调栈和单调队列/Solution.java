package _题型分类._单调栈和单调队列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/5 11:00
 */
public class Solution {
    /**
     * 单调栈
     */
    int[] nextGreaterElement(int[] nums) {
        int[] ans= new int[nums.length];// 存放答案的数组
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) { // 倒着往栈里放
            while (!s.isEmpty() && s.peek() <= nums[i]) { // 判定个子高矮
                s.pop(); // 矮个起开，反正也被挡着了。。。
            }
            ans[i] = !s.isEmpty() ? s.peek() : -1; // 这个元素身后的第一个高个
            s.push(nums[i]); // 进队，接受之后的身高判定吧！
        }
        return ans;
    }
    List<Integer> maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) { //先填满窗口的前 k - 1
                window.push(nums[i]);
            } else { // 窗口向前滑动
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

}

/**
 * 单调队列
 */
class MonotonicQueue {
    private Deque<Integer> data;
    public void push(int n) {
        while (!data.isEmpty() && data.pollLast() < n)
            data.pollLast();
        data.addLast(n);
    }

    int max() { return data.peekFirst(); }

    void pop(int n) {
        if (!data.isEmpty() && data.peekFirst() == n)
            data.pollFirst();
    }
};

