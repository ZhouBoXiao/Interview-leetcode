package _图论._最短路径;

import java.util.Arrays;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/18 22:11
 */
public class Solution {
    //Bellman-ford
    class Edge{
        int from, to, cost;
    }
    Edge[] es = new Edge[10000];
    int[] d = new int[10000];
    int V, E; // V 是顶点数， E是边数
    void shortestPath(int s) {
        for (int i = 0; i < V; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[s] = 0;
        // 复杂度 O(VE)
        while (true) {
            boolean update = false;
            for (int i = 0; i < E; i++) {
                Edge e = es[i];
                if (d[e.from] != Integer.MAX_VALUE && d[e.to] > d[e.from] + e.cost) {
                    d[e.to] = d[e.from] + e.cost;
                    update = true;
                }
            }
            if (!update) break;
        }
    }
    // 找出是否存在负圈
    boolean findNegativeLoop() {
        Arrays.fill(d, 0);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < E; j++) {
                Edge e = es[j];
                if (d[e.to] > d[e.from] + e.cost) {
                    d[e.to] = d[e.from] + e.cost;

                    if (i == V - 1) return true;
                }
            }
        }
        return false;
    }

    /**
     * Dijkstra
     */
    int[][]  cost = new int[10000][10000];
    boolean[] used = new boolean[10000];
    void dijkstra(int s) {
        Arrays.fill(d, 0, V, Integer.MAX_VALUE);
        d[s] = 0;

        while (true) {
            int v = -1;
            // 从尚未使用过的顶点中选择一个距离最小的顶点
            for (int u = 0; u < V; u++) {
                if (!used[u] && (v == -1 || d[u] < d[v])) {
                    v = u;
                }
            }
            if (v == -1) break;
            used[v] = true;

            for (int u = 0; u < V; u++) {
                d[u] = Math.min(d[u], d[v] + cost[v][u]);
            }
        }
    }
}
