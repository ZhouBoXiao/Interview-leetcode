package pdd;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/26 19:01
 */


import java.util.*;

public class Main {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] dp = new long[m+1][n+1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (i == 1 || j == 1) {dp[i][j] = 1; }
                else if (i == 2) {
                    if (i == 2 && j == 2) dp[i][j] = 2;
                    else dp[2][j] = dp[2][j - 1] + dp[2][j - 2];
                } else if (j == 2) {
                    if (i == 2 && j == 2) dp[i][j] = 2;
                    else dp[i][2] = dp[i - 1][2] + dp[i - 2][2];
                }
                else {

                    if (i > j) {
                        if (i >= 4)
                            dp[i][j] = (dp[2][j] + dp[i - 2][j] + dp[i - 1][j]) % MOD;
                        else
                            dp[i][j] = (dp[2][j] + dp[i - 2][j] ) % MOD;
                    } else if (j > i){
                        if (j >= 4)
                            dp[i][j] = (dp[i][2] + dp[i][j - 2] + dp[i][j - 1]) % MOD;
                        else
                            dp[i][j] = (dp[i][2] + dp[i][j - 2]) % MOD;
                    } else {
                        if (i == 2 && j == 2) dp[i][j] = 2;
                        else if (i == 3 && j == 3) dp[i][j] = 5;
                        else dp[i][j] = (dp[i][2] + dp[i][j - 2] + dp[i][j - 1]  + dp[i - 1][j - 1]) % MOD;
                    }
                    /*if (i == 2) {
                        //dp[i][j] += dp[i-1][j];
                        //dp[i][j] %= MOD;
                        dp[i][j] += dp[i][j - 1] + dp[i][j - 2];
                        dp[i][j] %= MOD;
                    } else if (i == 3){
                        dp[i][j] += dp[1][j] + dp[2][j];
                    } else if (i == 4) {
                        dp[i][j] += dp[3][j] + dp[2][j] * 2;
                    } else if (i == 5) {
                        dp[i][j] += dp[i - 1][j] + dp[3][j] + dp[2][j];
                    }*/

                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
