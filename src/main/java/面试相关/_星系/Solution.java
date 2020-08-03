package 面试相关._星系;
import java.util.*;
/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/8/2 14:58
 */
public class Solution {
    static int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        // int m = in.nextInt();
        int n = 5,  m = 7;
        String[] strs = new String[]{
                "*......",
                "..**..*",
                ".*...*.",
                "...*...",
                "....*.."
        };
        char[][] chs = new char[n][m];
        for (int i = 0; i < n; i++) {
            chs[i] = strs[i].toCharArray();
        }
        List<Integer> list = new ArrayList<>();
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ;j ++) {
                if (vis[i][j]) continue;
                if (chs[i][j] == '*') {
                    vis[i][j] = true;
                    int cur = dfs(chs, i , j, vis);
                    list.add(cur);
                }
            }
        }
        Collections.sort(list);
        int pre = list.get(0);
        int count = 1, max = 0, sum = pre;
        for (int i = 1; i < list.size() ;  i++) {
            if (list.get(i) != pre) {
                count++;
                max = Math.max(max, sum);
                sum = list.get(i);
                pre = list.get(i);
            } else {
                sum += list.get(i);
            }
        }

        System.out.println(count + " " + max);
    }

    static int dfs(char[][] chs, int x, int y, boolean[][] vis) {
        int count = 1;
        for (int i =0 ; i < 8; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if (dx < 0 || dy < 0 || dx >= chs.length || dy >= chs[0].length) continue;
            if (chs[dx][dy] != '*' || vis[dx][dy]) continue;

            vis[dx][dy] = true;
            count += dfs(chs, dx, dy, vis);

        }
        return count;
    }

}
