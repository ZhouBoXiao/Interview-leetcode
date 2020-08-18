package _sortByNumber._201_300._207_课程表;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] in = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        for (int[] e : prerequisites) {
            adjacency.get(e[1]).add(e[0]);
            in[e[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int val = queue.poll();
            numCourses--;
            for (int j : adjacency.get(val)) {
                if (--in[j] == 0)
                    queue.offer(j);
            }
        }
        return numCourses == 0;

    }*/

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for(int i = 0; i < numCourses; i++)
            if(!dfs(adjacency, flags, i)) return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        //说明在本轮 DFS 搜索中节点 i 被第 2 次访问，即 课程安排图有环 ，直接返回 False。
        if (flags[i] == 1) return false;
        //说明当前访问节点已被其他节点启动的 DFS 访问，无需再重复搜索，直接返回 True。
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (int j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j))
                return false;
        }
        flags[i] = -1;

        return true;
    }


}

