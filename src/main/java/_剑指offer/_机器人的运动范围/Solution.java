package _剑指offer._机器人的运动范围;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }

    private int dfs(int x, int y, int m, int n, int k) {
        if (x >= m || y >= n || visited[x][y]
                || (x % 10 + x / 10 + y % 10 + y / 10) > k) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, m, n, k) + dfs(x, y + 1, m, n, k);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 1));
    }

}
