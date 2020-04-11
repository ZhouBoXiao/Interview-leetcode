package _网易._4;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[][] map = new int[n][m];
        int[][] res = new int[n][m];
        int[][] ans = new int[n * m][2];
        int k = 0;
        for (int i = 0 ;i < n;i++) {
            String temp = scanner.next();
            for (int j = 0; j < m ; j++) {
                map[i][j] = temp.charAt(j) - '0';
                if (map[i][j] == 1) {
                    ans[k][0] = i;
                    ans[k++][1] = j;

                }
            }
        }
//        Queue<int[]> queue = new LinkedList<>();

        int[][] direct = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        for (int i = 0 ;i < k;i++) {
            Queue<int[]> queue = new LinkedList<>();
            int startX = ans[i][0];
            int startY = ans[i][1];

            queue.add(new int[]{startX, startY});
            int step = 0;
            while (!queue.isEmpty()) {

                int[] temp = queue.poll();

                int x = temp[0], y = temp[1];
                if (map[x][y] == 0) {
                    res[startX][startY] = Math.abs(x - startX) + Math.abs(y - startY) ;
                    break;
                }
                for (int[] d : direct) {
                    int endX = x + d[0];
                    int endY = y + d[1];
                    if (endX < 0 || endX >= n || endY < 0 || endY >= m) continue;
                    queue.offer(new int[]{endX, endY});
                }

            }
        }

        for (int i = 0 ;i < n;i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) System.out.print(res[i][j]);
                else System.out.print(" " + res[i][j]);

            }
            System.out.println();
        }
    }
}
/**

 3 3
 101
 010
 101

 */