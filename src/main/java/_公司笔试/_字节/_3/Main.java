package _公司笔试._字节._3;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/11 9:59
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder(scanner.nextLine());
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] c = new int[n];
        int[] a = new int[m];
        int[][] ans = new int[m][2];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();

        }
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        Arrays.sort(ans, (o1, o2)->{
            if (o1[0]==o2[0])
                return o1[1] - o2[1];
            return o1[0] = o2[0];
        });
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (c[a[i] - 1] != c[b[i] - 1]) {
                c[b[i] - 1] = c[a[i] - 1];
                cnt++;
            }
        }
        System.out.println(cnt);
        scanner.close();
    }
}
