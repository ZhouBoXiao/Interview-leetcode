package _公司笔试.leetcode._202_周赛;

import java.net.InetSocketAddress;
import java.util.*;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/25 18:18
 */
public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i % 2 != 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) return true;

        }
        return false;
    }
    // 使数组中所有元素相等的最小操作数
    public static int minOperations(int n) {
        int res = 0;
        if (n % 2 != 0) {
            int m = (n/2) * 2 + 1;
            for (int i = 0; i < n/2; i ++) {
                res += m - ( 2 * i + 1);
            }
            return res;
        } else {
            int m = (n/2) * 2 ;
            for (int i = 0; i < n/2; i ++) {
                res += m - ( 2 * i + 1);
            }
            return res;
        }
        //reutrn n * n / 4;
    }

    int check(int[] position, int mid) {
        int cnt = 1, last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= mid) {
                last = position[i];
                cnt++;
            }
        }
        return cnt;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int r = (position[position.length - 1] - position[0]) / (m - 1);
        int l = 0;
        while (l < r) {
            int mid = (l + r + 1) >>1;
            int cnt = 1, last = position[0];
            for (int i = 1; i < position.length; i++) {
                if (position[i] - last >= mid) {
                    last = position[i];
                    cnt++;
                }
            }
            if (cnt >= m) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    Map<Integer, Integer> d = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();

    void extend(int dist, int x) {
        if (d.containsKey(x)) return;
        d.put(x, dist + 1);
        q.add(x);
    }

    public int minDays1(int n) {
        q.add(n);
        d.put(n,  1);
        if (n == 1) return 1;
        while (!q.isEmpty()) {
            int t = q.poll();
            if (t == 1) return d.get(t);
            extend(d.get(t), t - 1);
            if (t % 2 == 0) extend(d.get(t), t/2);
            if (t % 3 == 0) extend(d.get(t), t/3);
        }
        return -1;
    }

    Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3)));
        return memo.get(n);
    }


    public static void main(String[] args) {
//        minOperations();
        new Solution().maxDistance(new int[]{1,2,3,4,7}, 3);
    }

}
