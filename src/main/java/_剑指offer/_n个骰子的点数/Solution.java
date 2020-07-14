package _剑指offer._n个骰子的点数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 14:00
 */

/**
 * 找状态转移方程也就是找各个阶段之间的转化关系，同样我们还是只需分析最后一个阶段，分析它的状态是如何得到的。
 *
 * 最后一个阶段也就是投掷完 nn 枚骰子后的这个阶段，我们用 dp[n][j]dp[n][j] 来表示最后一个阶段点数 jj 出现的次数。
 *
 * 单单看第 nn 枚骰子，它的点数可能为 1 , 2, 3, ... , 61,2,3,...,6 ，因此投掷完 nn 枚骰子后点数 jj 出现的次数，可以由投掷完 n-1n−1 枚骰子后，对应点数 j-1, j-2, j-3, ... , j-6j−1,j−2,j−3,...,j−6 出现的次数之和转化过来。
 *
 * for (第n枚骰子的点数 i = 1; i <= 6; i ++) {
 *     dp[n][j] += dp[n-1][j - i]
 * }
 * n 表示阶段，j表示投掷完 n 枚骰子后的点数和，i 表示第 n 枚骰子会出现的六个点数。
 */
public class Solution {

    public double[] twoSum(int n) {
        int[][] dp = new int[n+1][6*n+1];
        double[] ans = new double[5*n + 1];
        double all = Math.pow(6,n);
        for (int i = 1; i <= 6; i++) {
            dp[1][i]=1;
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = i; j <= 6*i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k < 0 ) {
                        break;
                    }
                    dp[i][j] += dp[i-1][j-k];
                    if (i == n) {
                        ans[j-i] = dp[i][j]/all;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().twoSum(2);
    }
}
