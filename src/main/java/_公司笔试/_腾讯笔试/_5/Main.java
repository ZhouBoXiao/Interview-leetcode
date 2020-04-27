package _公司笔试._腾讯笔试._5;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 翻转牌
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println(-1);
            return;
        }
        int[][] a = new int[n][2];
        for (int i = 0 ; i < n; i ++) {
            a[i][0] = scanner.nextInt();
        }
        for (int i = 0 ; i < n; i ++) {
            a[i][1] = scanner.nextInt();
        }
        int cnt = 0;
        for (int j = 0; j < n ; j++) {
            for (int i = 1; i < n; i++) {
                if (a[i - 1][0] > a[i][0]) {
                    swap(a, i, i-1);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

        scanner.close();
    }

    static void swap(int[][] a, int i, int j) {
        int temp1 = a[i][0];
        a[i][0] = a[j][1];
        a[j][1] = temp1;
        int temp2 = a[j][0];
        a[j][0] = a[i][1];
        a[i][1] = temp2;
    }
}
/*
1
1000000000000000000
60
 */