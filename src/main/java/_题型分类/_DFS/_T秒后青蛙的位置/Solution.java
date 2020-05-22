package _题型分类._DFS._T秒后青蛙的位置;

import java.util.*;
import java.util.stream.Collectors;


public class Solution {
    public double frogPosition1(int n, int[][] edges, int t, int target) {

        boolean[] visited = new boolean[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e: edges) {
            map.putIfAbsent(e[0], new LinkedList<>());
            map.get(e[0]).add(e[1]);
            map.putIfAbsent(e[1], new LinkedList<>());
            map.get(e[1]).add(e[0]);
        }
        return dfs(map, visited, t, target, 1, 1);
    }

    public double dfs(Map<Integer, List<Integer>> map, boolean[] visited, int t, int target, int cur, double p) {
        if (t < 0) {
            return 0;
        }
        List<Integer> next = map.getOrDefault(cur, Collections.emptyList()).stream().filter(i -> !visited[i]).collect(Collectors.toList());
        if (t == 0 || next.size() == 0) {
            return cur == target ? p : 0;
        }
        double res = 0;
        p /= next.size();
        visited[cur] = true;
        for (Integer n: next) {
            if ((res = dfs(map, visited, t - 1, target, n, p)) > 0) {
                return res;
            }
        }
        visited[cur] = false;
        return 0;
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
            graph[e[1] - 1].add(e[0] - 1);
        }
        boolean[] visited = new boolean[n]; visited[0] = true;
        double[] prob = new double[n]; prob[0] = 1f;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        while (!q.isEmpty() && t-- > 0) {

            for (int size = q.size(); size > 0; size--) {
                int u = q.poll(), nextVerticesCount = 0;
                for (int v : graph[u]) if (!visited[v]) nextVerticesCount++;
                for (int v : graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                        prob[v] = prob[u] / nextVerticesCount;
                    }
                }
                if (nextVerticesCount > 0) prob[u] = 0; // frog don't stay vertex u, he keeps going to the next vertex
            }
        }
        return prob[target - 1];
    }
}
