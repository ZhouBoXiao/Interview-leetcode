package _sortByNumber._600以上._785;

public class Solution {
    int n;
    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(colors, graph, i, 1) ) {
                return false;
            }
        }
        return true;

    }

    boolean dfs(int[] colors, int[][] graph, int index, int color) {
        colors[index] = color;


        for (int i = 0; i < graph[index].length; i++) {
            int k = graph[index][i];
            if (colors[k] == color) return false;
            if (colors[k] == 0 && !dfs(colors, graph, k, -color)) {
                return false;
            }
        }
        return true;


    }

//    public static void main(String[] args) {
//        new Solution().isBipartite();
//    }
}
