package _公司笔试._携程._1;

import java.util.Scanner;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/7 9:56
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n;

        n = Integer.parseInt(in.nextLine().trim());
        long[] dp = new long[n + 1];
        dp[0] = 0; dp[1] = 1 ; dp[2] = 2;
        if (n < 0) {
            System.out.println(-1);
            return;
        }
        if (n < 3) {
            System.out.println(dp[n]);
            return;
        }
        for (int i = 3; i <= n; i++ ) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        if (n == 3) {
            System.out.println(4);
            return;
        }
        long res = dp[n];
        for (int i = 3; i <= n; i++) {
            if (i == 3) {
                res += dp[n-i];
            } else if ( i == n) {
                res += dp[i-3];
            }
            else res += dp[i-3]  * dp[n-i];
        }

        System.out.println(res);
    }
}
