package _公司笔试._xc._1;


/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/8 19:19
 */


import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int[][] dir = new int[][]{{0, 1},{1, 0},{0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); int m = sc.nextInt(); int e0 = sc.nextInt(); int x = sc.nextInt(); int l = sc.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int[][] vis = new int[n][m];
        dfs(array, 0, 0 , 0, e0, x, l , n , m, 0, vis);

        System.out.println(min);
        sc.close();
    }

    static void dfs(int[][] array, int step, int x, int y, int e0, int chance, int l, int n, int m, int direction, int[][] vis) {

        if (x == n - 1 && y == m - 1) {
            min = Math.min(min, step);
            return;
        }

       // for (int i = 0; i < 4; i++) {
            int dx = x + dir[direction][0];
            int dy = y + dir[direction][1];
            while (check(dx, dy, array, vis, step) || array[dx][dy] > (l + e0) || ( array[dx][dy] > e0 && chance == 0)) {
                direction = (direction + 1) % 4;
                dx = x + dir[direction][0];
                dy = y + dir[direction][1];
            }

            boolean flag = false;
            if (array[dx][dy] > e0) {
                if (chance <= 0) {};
                if (chance > 0) {
                    e0 += l  - array[dx][dy];
                    chance--;
                    flag = true;
                }
            } else {
                e0 -= array[dx][dy];
            }

            dfs(array, step + 1, dx, dy, e0, chance, l, n, m, direction, vis);
            vis[dx][dy] = step;
            if (flag) {
                chance++;
                e0 -= l - array[dx][dy];
            } else {
                e0 += array[dx][dy];
            }
    }

    private static boolean check(int dx, int dy, int[][] array, int[][] vis,int  step) {
       // if (vis[dx][dy])
        if (dx < 0 || dy < 0 || dx >= array.length || dy >= array[0].length) return true;
        return false;
    }
}
