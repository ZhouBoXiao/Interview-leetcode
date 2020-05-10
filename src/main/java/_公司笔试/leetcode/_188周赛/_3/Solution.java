package _公司笔试.leetcode._188周赛._3;

import java.util.*;
/*
收集树上所有苹果的最少时间

给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，
需要花费 1 秒钟。你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
 */

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/10 10:21
 */
public class Solution {
    int res = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Boolean> has;
    int ans;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        has = hasApple;
        for (int[] e : edges) {
            if (map.containsKey(e[0])) {
                map.get(e[0]).add(e[1]);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(e[1]);
                map.put(e[0], tmp);
            }
            if (map.containsKey(e[1])) {
                map.get(e[1]).add(e[0]);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(e[0]);
                map.put(e[1], tmp);
            }
        }
        dfs1(0, -1);

        ans = 0;
        dfs2(0, -1);

        return res;
    }
    void dfs1(int u, int fa) {
        for (int v: map.get(u)) {
            if (v != fa) {
                dfs1(v, u);
                has.set(u, has.get(u) | has.get(v));
               // has[u] = has[u] | has[v];
            }
        }
    }

    void dfs2(int u, int fa) {
        for (int v: map.get(u)) {
            if (v != fa && has.get(v)) {
                ++ans;
                dfs2(v, u);
                ++ans;
            }
        }
    }

}
