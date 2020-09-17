package _公司笔试.leetcode._205周赛;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/6 14:15
 */
public class Main {
    public String modifyString(String s) {
        int n = s.length();

        StringBuilder sb =new StringBuilder(s);
        for (int i =0 ; i< n; i++) {
            if (sb.charAt(i) == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (i + 1 < n && c == sb.charAt(i + 1))  continue;
                    if (i - 1 >= 0 && c == sb.charAt(i - 1)) continue;
                    sb.setCharAt(i, c);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> s1 = new HashMap<>();
        Map<Long, Integer> s2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            long t = (long) nums1[i] * nums1[i];
            s1.put(t, s1.getOrDefault(t, 0 ) + 1);
        }
        for (int j = 0; j < nums2.length; j++) {
            long t = (long) nums2[j] * nums2[j];
            s2.put(t, s2.getOrDefault(t, 0 ) + 1);
        }
        int res = 0;
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long t = (long) nums2[i] * nums2[j];
                if (s1.containsKey(t) ){
                    res+=s1.get(t);
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long t = (long) nums1[i] * nums1[j];
                if (s2.containsKey(t) ){
                    res += s2.get(t);
                }
            }
        }
        return res;
    }
    public int minCost(String s, int[] cost) {
        int sum = 0;
        int n = cost.length;
        boolean[] used = new boolean[n];
        for (int i = 1; i < s.length(); i++) {
            int left = i - 1;
            while (left >= 0 && used[left]) {
                left--;
            }
            if (left == -1 || s.charAt(left) != s.charAt(i)) continue;
            if (cost[i] < cost[left]) {
                sum += cost[i];
                used[i] = true;
            } else {
                sum += cost[left];
                used[left] = true;
            }
        }
        return sum;
    }


    private void union(int[] p, int x, int y) {
        int px = find(p, x);
        int py = find(p, y);
        if(px != py) {
            p[px] = py;
        }
    }

    int find(int[] p, int x) {
        if (p[x] == x) return x;
        else return p[x] = find(p, p[x]);
    }

    boolean isSame(int[] p, int x, int y) {
        return find(p, x) == find(p, y);
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] p = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[0] != 3) continue;
            if (isSame(p, edge[1], edge[2])) {
                ans ++;
            } else {
                union(p, edge[1], edge[2]);
            }
        }
        int[] px = Arrays.copyOf(p, p.length);
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (isSame(p, edge[1], edge[2])) {
                    ans ++;
                } else {
                    union(p, edge[1], edge[2]);
                }

            } else if(edge[0] == 2) {
                if (isSame(px, edge[1], edge[2])) {
                    ans ++;
                } else {
                    union(px, edge[1], edge[2]);
                }
            }
        }
        int root = find(px, 1);
        for (int i = 2; i <= n ; i++) {
            if (find(px, i) != root) return -1;
        }
        root = find(p, 1);
        for (int i = 2; i <= n ; i++) {
            if (find(p, i) != root) return -1;
        }
        return ans;
    }

}
