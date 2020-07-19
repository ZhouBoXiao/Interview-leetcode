package _公司笔试.leetcode._198周赛._5465;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 *
给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0  到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges 。树的根节点为节点 0 ，树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ）

边数组 edges 以 edges[i] = [ai, bi] 的形式给出，该格式表示节点 ai 和 bi 之间存在一条边。

返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。

树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树。

     * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/19 12:56
 */
public class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] ans = new int[n];
        dfs(new boolean[n], graph, ans,labels, 0);
        return ans;

    }

    int[] dfs(boolean[] visited, Set<Integer>[] graph,int[] ans, String labels, int start) {
        int[] count = new int[26];
        visited[start] = true;
        count[labels.charAt(start) - 'a']++;
        for (int i : graph[start]) {
            if (!visited[i]) {

                visited[i] = true;
                int[] temp = dfs(visited, graph,ans, labels, i);
                for (int j = 0; j < 26; j++) {
                    count[j] += temp[j];
                }
            }
        }

        ans[start] = count[labels.charAt(start) - 'a'];
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed")));
    }
}
