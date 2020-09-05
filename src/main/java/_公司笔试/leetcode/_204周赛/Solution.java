package _公司笔试.leetcode._204周赛;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/31 9:50
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int[] first = new int[m];
        int n = arr.length;
        int j;
        for (int i = 0; i <= n - m * k; i++) {
            for (j = i + m; j < i + m * k; j++) {
                if (arr[j] != arr[j - m]) break;
            }
            if (j == i + m * k) return true;
        }
        return false;
    }

    public int getMaxLen(int[] nums) {
        int res = 0;
        int z = 0,f = 0;
        for (int n : nums) {
            if (n == 0) {
                z = 0; //正数长度
                f = 0; // 负数长度
            } else if (n > 0) {
                z++;
                if (f > 0) f++;
                res = Math.max(res, z);
            } else {
                int temp = z;  z = f; f = temp;
                f++;
                if (z > 0) z++;
                res = Math.max(res, z);
            }
        }
        return res;
    }


    public int getMaxLen1(int[] nums) {

        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        if (nums[0] > 0) f[0] = 1;
        else if (nums[0] < 0) g[0] = 1;
        int res = f[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                f[i] = f[i - 1] + 1;
                if (g[i-1] > 0) g[i] = g[i - 1] + 1;
            } else if (nums[i] < 0){
                g[i] = f[i - 1] + 1;
                if (g[i - 1] > 0) f[i] = g[i - 1] + 1;
            }
            res = Math.max(res, f[i]);
        }

        return res;
    }

    class Pair<K,V> {
        K key;
        V value;

        public Pair(K x, V y) {
            key = x;
            value = y;
        }
    }
    int[] dx = new int[]{-1,  1, 0, 0};
    int[] dy = new int[]{ 0, 0, -1, 1};

    boolean check(int[][] grid) {
        int x = 0, y = 0;
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                cnt++;
                x = i;
                y = j;
            }
        }
        if (cnt == 0) {
            return true;
        }
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        boolean[][] mark = new boolean[30][30];
        q.add(new Pair<>(x, y));
        mark[x][y] = true;
        cnt--;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> f = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + f.key;
                int ny = dy[i] + f.value;
                if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length && grid[nx][ny] == 1) {
                    if(mark[nx][ny]) continue;
                    mark[nx][ny] = true;
                    q.add(new Pair<>(nx, ny));
                    cnt--;
                }
            }
        }
        return cnt != 0;

    }
    public int minDays(int[][] grid) {
        if (check(grid)) {
            return 0;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    continue;
                }
                grid[i][j] = 0;
                if(check(grid)) {
                    return 1;
                }
                grid[i][j] = 1;
            }
        }
        return 2;
    }

    int MOD = (int) (1e9 + 7);

    public int numOfWays(int[] nums) {
        int n = nums.length;
        int[][] C = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) C[i][j] = 1;
                else C[i][j] = (C[i-1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }
        return (f(list, C) + MOD - 1)  % MOD;
    }


    private int f(List<Integer> nums, int[][] C) {
        if (nums.isEmpty()) return 1;
        int n = nums.size();
        int k = nums.get(0);
        // 假设第一个是k ， 小于k的数有k - 1个， 大于k的有n- k个
        List<Integer> left  = new ArrayList<>();
        List<Integer> right  = new ArrayList<>();
        for (int x : nums) {
            if (x < k) left.add(x);
            else if (x > k) right.add(x - k);
        }
        //选择第一个作为根节点， 把数组分成左子树和右子树， C(n - 1)(k - 1)
        return (int) ((long) C[n - 1][k - 1] * f(left, C) % MOD * f(right, C) % MOD);
    }




    public static void main(String[] args) {
        System.out.println(new Solution().getMaxLen(new int[]{-1,-2,-3,0,1}));
    }

}
