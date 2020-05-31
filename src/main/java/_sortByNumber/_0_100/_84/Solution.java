package _sortByNumber._0_100._84;

import java.util.*;

/**
 * 柱状图中最大的矩形
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque < Integer > stack = new ArrayDeque < > ();

        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }


    public int largestRectangleArea1(int[] heights) {
        int  n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0 ;i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.pollLast();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        stack.clear();
        for (int i = n - 1 ;i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.pollLast();
            }
            right[i] = stack.isEmpty() ? n : stack.peekLast();
            stack.addLast(i);
        }
        int max = 0;
        for (int i = 0 ; i < n; i++) {
            max = Math.max(max, ( right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;  // 当前peek 比i大，所有右边界是i
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

}
