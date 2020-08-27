package _公司笔试.leetcode._33_双周赛;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/25 15:52
 */

import java.util.*;


public class Main {
    public String thousandSeparator(int n) {

        String s = String.valueOf(n);
        if (n < 1000) return s;
        char[] chs =  new char[s.length() + (s.length() - 1)/3];
        int j = 0, k = chs.length - 1;
        for (int i =  s.length() - 1 ; i >= 0; i--) {
            j++;
            chs[k--] = s.charAt(i);
            if (j == 3 && i != 0) {
                chs[k--] = '.';
                j = 0;
            }
        }
        return new String(chs);
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] canVisit = new boolean[n];
        for (List<Integer> edge : edges) {
            canVisit[edge.get(1)] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!canVisit[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public int minOperations(int[] nums) {
        int max = 0;
        int count = 0 ;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            count += Integer.bitCount(nums[i]);
        }
        count += Integer.toBinaryString(max).length()- 1;
        return count;
    }
    public int minOperations1(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        while (nums[n - 1] != 0) {
            for (int i =0 ; i < n; i++) {
                if ((nums[i] & 1 ) != 0) {
                    nums[i]--;
                    ans++;
                }
            }
            for (int i =0 ; i < n; i++) {
                nums[i]/=2;
            }
            ans++;
        }
        return ans - 1;
    }

    public boolean containsCycle(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        DSU dsu = new DSU(w * h);
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                char cur = grid[i][j];
                // 向右搜索
                if (j + 1 < w && cur == grid[i][j + 1]) {
                    if (dsu.union(i * w + j, i * w + j + 1)) {
                        return true;
                    }
                }
                // 向下搜索
                if (i + 1 < h && cur == grid[i + 1][j]) {
                    if (dsu.union(i * w + j, (i + 1) * w + j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    class DSU {
        int[] parent;

        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * 若合并前，x和y的parent相同，则表示形成环，返回true。
         *
         * @param x
         * @param y
         * @return
         */
        public boolean union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return true;
            }
            if (parentX < parentY) {
                parent[parentY] = parentX;
            } else {
                parent[parentX] = parentY;
            }
            return false;
        }
    }

}
