package _pdd._2;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/8/2 18:47
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int t = scanner.nextInt();
        int[][] a  = new int[n][2];
        int[][] b  = new int[m][2];
        if (t == 0 ) {
            System.out.println(0);
            return;
        }
        int[]  min = new int[]{Integer.MAX_VALUE, -1};
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            if (a[i][1] >= t) {
                min[0] = Math.min(a[i][0], min[0]);
                //min[1] = i;
            }
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = scanner.nextInt();
            b[i][1] = scanner.nextInt();
            if (b[i][1] >= t) {
                min[0] = Math.min(b[i][0], min[0]);
               // min[1] = b[i][0];
            }
        }
        // min[0] 热量值
        if (min[0] != Integer.MAX_VALUE) {
            System.out.println(min[0]);
            return;
        }
        min[0] = Integer.MAX_VALUE; min[1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][1] + b[j][1] > t ){

                    min[0] = Math.min(a[i][0] + b[j][0], min[0]);
                    //min[1] = i;
                }
            }
        }
        if (min[0] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min[0]);
        }
        scanner.close();
    }

}
