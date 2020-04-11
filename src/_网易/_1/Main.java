package _网易._1;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int n ;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
//        long[] a = new long[n];
        long[] b = new long[n-1];
        long pre = scanner.nextLong();
        long min = Integer.MAX_VALUE;
        long max = -1;
        long cur = 0;
        long D = -1;
        for (int i = 0; i < n - 1; i++) {
            cur = scanner.nextLong();
            b[i] = cur - pre;
            pre = cur;
            if (b[i] < 0) {
                System.out.println(D);
                return;
            }
            max = Math.max(max, b[i]);
            min = Math.min(min, b[i]);
        }

        if (min == 0 || max == 0) {
            System.out.println(D);
            return;
        }
        for (long d = min; d <= max; d += min) {
            boolean flag = true;
            for (int i = 0 ; i < n - 1; i++) {
                if (b[i] % d != 0) {

                    flag = false;
                    break;
                }

            }
            if (flag) {
                D = d;
            }
        }

        System.out.println(D);
        scanner.close();
    }
}
/***
 *
 4
 1 3 7 15
 */