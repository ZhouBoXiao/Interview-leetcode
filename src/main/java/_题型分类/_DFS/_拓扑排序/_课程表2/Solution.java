package _题型分类._DFS._拓扑排序._课程表2;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] flags = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ;i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] d : prerequisites) {
            list.get(d[1]).add(d[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(flags, list, i, stack) ) {
                return new int[0];
            }
        }
        int[] res = new int[stack.size()];
        int index = 0;
        for (int i = 0; i < numCourses ; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean dfs(int[] flags, List<List<Integer>> list, int i, Stack<Integer> stack) {

        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;

        flags[i] = 1;

        for (int j : list.get(i)){
            if (!dfs(flags, list, j, stack)) {
                return false;
            }
        }
        stack.push(i);
        flags[i] = -1;
        return true;

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,0}
        };
        new Solution().findOrder(2, nums);
    }
}
