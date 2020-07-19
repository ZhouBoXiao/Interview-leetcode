package _公司笔试.leetcode._198周赛._5467;

import java.util.*;

/**
 * @Description:
 *
     * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/19 12:56
 */
public class Solution {
    public int closestToTarget(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (list.isEmpty() || i != list.get(list.size() - 1)) {
                list.add(i);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int X = list.get(i);
            for (int j = i; j < list.size(); j++) {
                X &= list.get(j);
                ans = Math.min(ans, Math.abs(target - X));
                if (X <= target) {
                    break;
                }
            }
        }
        return ans;
    }
}
