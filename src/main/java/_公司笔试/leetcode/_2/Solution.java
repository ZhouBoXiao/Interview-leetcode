package _公司笔试.leetcode._2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minJump(int[] jump) {

        int[] d = new int[jump.length];

        int n = jump.length, mx = 0;
        //vector<int> d(n, -1);
        Arrays.fill(d, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        d[0] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();

            if (x + jump[x] >= n) return d[x]+1;

            if (d[x+jump[x]] == -1) {
                d[x+jump[x]] = d[x]+1;
                q.offer(x+jump[x]);
            }

            for (int i = mx+1; i < x; ++i) {
                if (d[i] == -1) {
                    d[i] = d[x]+1;
                    q.offer(i);
                }
            }
            mx = Math.max(mx, x);
        }
        return n;

    }

    /*private void dfs(int[] jump, int cur, int sum, int n) {
        if (sum >= min) {
            return;
        }

        if (jump[cur] + cur >= n && sum < min) {
            min = sum;
        }

        dfs(jump, cur + jump[cur], sum + 1 , n);
        for (int i = 1; i <= cur; cur++) {
            dfs(jump, cur - i, sum + 1 , n);
        }
    }*/

    public static void main(String[] args) {
        int[] jump = new int[]{2,5,1,1,1,1};
        new Solution().minJump(jump);
    }
}
