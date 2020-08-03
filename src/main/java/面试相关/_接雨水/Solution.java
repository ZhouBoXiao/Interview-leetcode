package 面试相关._接雨水;

import java.util.Stack;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/6 22:56
 */
public class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        int sum = 0;
        while (cur < height.length) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int s = stack.pop();
                if (stack.isEmpty()) break;
                int distance = cur - stack.peek() - 1;
                int bound = Math.min(height[stack.peek()], height[cur]) - height[s];
                sum += distance * bound;

            }
            stack.push(cur++);
        }
        return sum;
    }
    public int trap1(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0 ; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            int level = Math.min(left[i], right[i]);
            water += Math.max(0, level - height[i]);

        }
        return water;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int lmax = 0, rmax = 0;
        int left = 0, right = n - 1;
        int res = 0;
        while (left <= right) {

            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);
            if (lmax < rmax) {
                res += lmax - height[left];
                left++;
            } else {
                res += rmax - height[right];
                right--;
            }
        }
        return res;
    }
}
