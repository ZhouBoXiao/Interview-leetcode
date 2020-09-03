package _sortByNumber._600以上._1568_使陆地分离的最少天数;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/31 21:03
 */


public class Solution {

    class Pair<K,V> {
        K key;
        V value;

        public Pair(K x, V y) {
            key = x;
            value = y;
        }
    }
    int[] dx = new int[]{-1,  1, 0, 0};
    int[] dy = new int[]{ 0, 0, -1, 1};

    boolean check(int[][] grid) {
        int x = 0, y = 0;
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                cnt++;
                x = i;
                y = j;
            }
        }
        if (cnt == 0) {
            return true;
        }
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        boolean[][] mark = new boolean[30][30];
        q.add(new Pair<>(x, y));
        mark[x][y] = true;
        cnt--;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> f = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + f.key;
                int ny = dy[i] + f.value;
                if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length && grid[nx][ny] == 1) {
                    if(mark[nx][ny]) continue;
                    mark[nx][ny] = true;
                    q.add(new Pair<>(nx, ny));
                    cnt--;
                }
            }
        }
        return cnt != 0;

    }
    public int minDays(int[][] grid) {
        if (check(grid)) {
            return 0;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    continue;
                }
                grid[i][j] = 0;
                if(check(grid)) {
                    return 1;
                }
                grid[i][j] = 1;
            }
        }
        return 2;
    }

}
class Sol{
    private int row, col;
    private int[][] mat;
    private int[][] ids;
    private int[] dx = new int[]{-1, 0, 1, 0};

    private int[] dy = new int[]{0, 1, 0, -1};

    private int[] fa, dfn, low;

    private int t;

    private int find(int x) {
        if (x == fa[x]) return x;
        else return fa[x] = find(fa[x]);
    }

    private boolean check(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public int minDays(int[][] grid) {

        mat = grid;
        row = mat.length;
        col = mat[0].length;

        ids = new int[row][col];
        int id = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) ids[i][j] = ++id;
            }
        }

        fa = new int[id + 1];
        dfn = new int[id + 1];
        low = new int[id + 1];
        for (int i = 0; i <= id; i++) fa[i] = i;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (check(x, y) && mat[x][y] == 1) {
                            int r1 = find(ids[i][j]);
                            int r2 = find(ids[x][y]);
                            if (r1 == r2) continue;
                            fa[r2] = r1;
                        }
                    }
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i <= id ; i++) {
            if (fa[i] == i) cnt++;
        }
        if (cnt == 0 || cnt > 1) return 0;
        
        return tarjan() || id == 1 ? 1 : 2;

    }

    private boolean tarjan() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) continue;
                if (dfs(i, j, ids[i][j])) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int root) {
        dfn[ids[i][j]] = low[ids[i][j]] = ++t;
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (!check(x, y) || mat[x][y] != 1) continue;
            if (dfn[ids[x][y]] == 0) {
                if (ids[i][j] == root) cnt++;
                if (dfs(x, y, root)) return true;
                low[ids[i][j]] = Math.min(low[ids[i][j]], low[ids[x][y]]);
                if (ids[i][j] != root && low[ids[x][y]] >= dfn[ids[i][j]]) return true;
            }
            low[ids[i][j]] = Math.min(low[ids[i][j]], dfn[ids[x][y]]);
        }
        return ids[i][j] == root && cnt > 1;
    }


}