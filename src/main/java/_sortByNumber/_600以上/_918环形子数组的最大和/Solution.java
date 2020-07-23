package _sortByNumber._600以上._918环形子数组的最大和;


import java.util.*;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/23 22:55
 */
public class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            nums.add(A[i]);
        }
        for (int i = 0 ; i < n; i++) {
            nums.add(A[i]);
        }
        int[] sum = new int[2 * n + 1];
        for (int i = 1 ; i <= 2*n; i++) {
            sum[i] = sum[i- 1] + nums.get(i - 1);
        }
        int res = Integer.MIN_VALUE;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 2*n; i++) {
            if (!q.isEmpty() && i - n > q.peekFirst()) q.pollFirst();
            if (!q.isEmpty()) {
                res = Math.max(res, sum[i] - sum[q.peekFirst()]);
            }
            while (!q.isEmpty() && sum[q.peekLast()] >= sum[i]) q.pollLast();
            q.addLast(i);
        }
        return res;
    }
}
