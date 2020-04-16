package _201_300._207;
import javax.print.attribute.EnumSyntax;
import java.util.*;

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

        if (flags[i] == 1) return false;
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

