package _公司笔试._tenxun._4;

import java.util.*;

/**
 * @Description:
 *
 * 有n（n在5000内）块木板，宽度是1，长度不固定，这些小木板拼接起来一块大木板。
 *
 * 给一个宽度为1的刷子，每刷一次可以选择横着刷和竖着刷，过程中都不能离开木板。
 *
 * 问最少要刷几次能把木板完全刷一遍。
 *
 * 动态规划题，dp[i][j]dp[i][j]表示当前完全刷完了前ii块木板，横着刷的部分能延伸到之后木板的部分高度为jj的最小代价，显然jj不会超过nn，因为所有木板竖着刷答案就是nn了，不存在横着刷高度超过nn的情况。
 *
 * 我们枚举所有的状态，转移情况如下：
 *
 * 竖着刷
 *
 * 此时代价是1，能延伸的部分是jj和当前木板高度取最小值。
 *
 * 横着刷
 *
 * 如果当前木板高度小于jj，则没有代价，否则要补上他们之间的差值，能延伸的部分是当前木板的高度。
 * @Author: boxiao
 * @Date: 2020/8/23 20:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[][] dp = new int[n +1][n+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= n; j++) {
                int high;
                //竖着刷
                high = Math.min(j, a[i + 1]);
                dp[i + 1][high] = Math.min(dp[i + 1][high], dp[i][j] + 1);
                //横着刷
                if(a[i + 1] < n) {
                    if (j >= a[i + 1])  dp[i + 1][a[i + 1]] = Math.min(dp[i + 1][a[i + 1]], dp[i][j]);
                    else dp[i + 1][a[i + 1]] = Math.min(dp[i + 1][a[i + 1]], dp[i][j] + a[i + 1] - j);
                }
            }
        }
        int ans = n;
        for(int i = 0; i <= n; i++) ans = Math.min(dp[n][i], ans);
        System.out.println(ans);
    }
}
