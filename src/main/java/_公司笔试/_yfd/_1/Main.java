package _公司笔试._yfd._1;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/8/1 18:44
 */
public class Main {
    static int MOD = 1000000003;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        Arrays.sort(a, (o1, o2) -> {
//            if (o1[1] == o2[1]) {
//                return o1[0] - o2[0];
//            } else {
//                return o1[1] - o2[1];
//            }
            return o1[1] - o2[1];
        });
        long max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            long preSum = a[i][0];
            for (int j = i + 1; j < n; j++) {
                preSum = preSum > 0 ? preSum + a[j][0] : a[j][0];
            }
            max = max > MOD ? max % MOD : max;
            max = Math.max(max, preSum);
        }
        System.out.println(max);
        scanner.close();
    }
}
