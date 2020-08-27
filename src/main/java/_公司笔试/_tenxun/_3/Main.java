package _公司笔试._tenxun._3;
/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/23 19:59
 */


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0 ) {

            long n = scanner.nextLong();
            if (n < 10) {
                System.out.println(n);
                continue;
            }
            long  a = 0;
            while(a <= n)a = a * 10 + 9;
            a /= 10;
            System.out.println(get(a, n - a));
        }
    }

    static long get(long x, long y) {
        String s = String.valueOf(x);
        String s1 = String.valueOf(y);
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i) - '0';
        }
        for (int i = 0; i < s1.length(); i++) {
            res += s1.charAt(i) - '0';
        }
        return res;
    }

}

