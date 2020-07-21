package _ali._1;

import java.util.*;

public class Main {

    static long gcd(long a, long b) {
        return b == 0 ?  a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            boolean flag = false;
            if ( n % k != 0) {
                System.out.println(-1);
                continue;
            }
            long p = n / k;

            for (long x = 1; x <= p - 3 && !flag; x++) {
                for (long y = x + 1; y < p - x && !flag; y++) {
                    long z =  (p - x - y);
                    if (z != x && z != y) {
                        long temp1 = gcd(z, x);
                        if (temp1 != 1 ) continue;
                        long temp2 = gcd(z, y);
                        if (temp2 != 1 ) continue;
                        long temp3 = gcd(x, y);
                        if (temp3 != 1 ) continue;
                        System.out.println(x* k+ " " + y * k + " " + z * k);
                        flag = true;
                    }
                }
            }
            if (!flag) System.out.println(-1);
        }
        scanner.close();
    }
}
/**
3
6 1
12 4
38 2

 */