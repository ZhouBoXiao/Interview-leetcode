package _sortByNumber._600以上._739_每日温度;

import java.util.Stack;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/11 12:42
 */
public class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        int[] res = new int[nums.length];
        while (cur < nums.length) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[cur]) {
                int temp = stack.pop();
                res[temp] = cur - temp;
            }
            stack.push(cur);
            cur++;
        }
        return res;
    }
}
