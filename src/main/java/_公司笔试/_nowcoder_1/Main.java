package _公司笔试._nowcoder_1;

import org.redisson.misc.Hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/15 18:58
 */
public class Main {
    static int MOD = 998244353;
    static int ans = 0;
    static double[] nums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int k = 0;
        for (int i = 1; i*i <= m; i++) {
            if (m % (i*i) == 0) {
                k = i;
            }
        }
        int[][] dp = new int[1000][1000];
        int sum = k, cnt = Math.min(n, sum);
        // dp(i, j) <=j 个正整数和为i

        for (int i = 0; i <= cnt; i++) dp[0][i] = 1;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= cnt; j++) {
                dp[i][j] = dp[i][j-1];
                if (i >= j) {
                    dp[i][j] += dp[i-j][j];
                    if (dp[i][j] >= MOD) dp[i][j] -= MOD;
                }
            }
        }
        System.out.println(dp[sum][cnt]);
    }

}
// 1000 1000000