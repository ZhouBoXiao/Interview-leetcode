package _公司笔试._网易._3;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 12:35
 */

import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            long p = sc.nextLong();
            long q = sc.nextLong();
            if (A >= B) {
                System.out.println(0);
                return;
            }
            int cnt = 0;
            if (A + p >= B) {
                System.out.println(1);
            } else {
                while (A + p < B) {
                    p *= q;
                    cnt ++;
                }
                System.out.println(cnt + 1);
            }
        }
        sc.close();
    }
}