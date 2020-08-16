package _公司笔试._pdd._3;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/8/2 18:47
 */


import java.util.Scanner;

public class Main {
    static int MOD = 1000000009;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chars = new char[6][6];
        for (int i = 0; i < 6; i++) {
            chars[i] = scanner.nextLine().toCharArray();
        }
        long res = 1;
        boolean[][] vis = new boolean[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (vis[i][j] ) continue;
                if (chars[i][j] == '#') {
                    int cur = 0;
                    vis[i][j] = true;
                    for (int k = 0; k < 6; k++) {
                        chars[i][j] = (char) (k + '0');
                        cur += dfs(i,j,k,chars);
                        chars[i][j] = '#';
                    }
                    if (res > MOD) res%=MOD;
                    res *= cur;

                }
            }
        }
        System.out.println(res);
        scanner.close();
    }
    static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private static int dfs(int x, int y, int k, char[][] chars) {
        int count = 1;
        for (int t = 0; t < 6; t++) {
            if (k != t) {
                for (int i =0 ; i< 4; i++) {
                    int dx = x + dir[i][0];
                    int dy = y + dir[i][1];
                    if (dx < 0 || dy < 0 || dx >= chars.length || dy >= chars[0].length || chars[dx][dy] != '#') continue;
                    if (!ok(chars, k, dx,dy)) continue;
                    chars[dx][dy] = (char) ( t + '0');
                    count += dfs(dx, dy, t, chars);
                    chars[dx][dy] = '#';
                }
            }
        }
        return count;
    }

    private static boolean ok(char[][] chars, int k, int dx, int dy) {
        if (dx > 0 && chars[dx-1][dy] == k) return false;
        if (dy > 0 && chars[dx][dy-1] == k) return false;
        if (dy < chars[0].length - 1 && chars[dx][dy+1] == k) return false;
        if (dx < chars.length - 1 && chars[dx + 1][dy] == k) return false;
        return true;
    }


}
