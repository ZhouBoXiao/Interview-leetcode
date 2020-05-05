package _0_100._11_盛最多水的容器;

import java.util.Stack;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/5 10:47
 */
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0, h = 0;
        while(l < r) {
            h = Math.min(height[l], height[r]);
            max = Math.max(max, h * (r - l));
            while(height[l] <= h && l < r) l++;
            while(height[r] <= h && r > l) r--;
        }
        return max;
    }
}
