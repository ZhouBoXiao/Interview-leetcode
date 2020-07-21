package _ali._2;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int count = 0;
            for (int i = l; i <= r ; i++) {
                count += check(i);
            }
            System.out.println(count);
        }
        scanner.close();
    }

    private static int check(int x) {
        int[] a = new int[15];
        while (true) {
            int tmp = x;
            if (x >= 0 && x < 10) {
                if (x == 7) {
                    return 1;
                } else {
                    return 0;
                }
            }
            int cnt = 0;
            while (tmp > 0) {
                a[cnt] = tmp % 10;
                cnt ++;
                tmp/=10;
            }
            x = 0;
            for (int i = cnt - 1; i >= 1; i--) {
                x = x * 10 + Math.abs(a[i] - a[i-1]);
            }
        }
    }
}
/*

3
1 10
1 1000
1 100000


 */