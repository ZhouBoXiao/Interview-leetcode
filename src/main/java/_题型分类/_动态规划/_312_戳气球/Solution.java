package _题型分类._动态规划._312_戳气球;

/**
 * @Description:
 *
 *  状态表示：
 * dp[i][j]表示nums中[i,j]的气球全部被戳破的集合
 * 属性值：Max，从[i,j]气球全部被戳破的最大***数量
 * 状态计算：
 * 扩展数组，加上题中的nums[-1] = nums[n] = 1，这样计算动态规划新数组的[1,n]
 * 先戳破[i,k - 1]和[k + 1, j]的气球，最后戳破第k个气球。dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + s[i - 1] * s[k] * s[j + 1]);
 * dp[i][k - 1] + dp[k + 1][j]表示[i,k - 1]与[k + 1, j]被戳破所获得的最大coins数，s[i - 1] * s[k] * s[j + 1]表示最后戳破第k个气球所获得coins数目。
 * k 遍历[i,i + len - 1]，保存最大值。
 * 初始化：
 * 全部初始化为0
 *
 * @Author: boxiao
 * @Date: 2020/9/8 12:47
 */
public class Solution {

    public int maxCoins(int[] nums) {
        // dp[i][j]表示nums中i到j的气球全部被戳破的集合。
        // 属性：Max，气球全部被戳破的最大coins数量。
        // dp[i][j] : 先戳破[i, k - 1]和[k + 1, j]的气球，最后戳破第k个气球获得转移方程。
        int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n + 3][n + 3];
        // dp数组初始化为0
        int[] s = new int [n + 2];
        s[0] = s[n + 1] = 1;
        for(int i = 1; i <= n; i++){
            s[i] = nums[i - 1];
        }
        // 一重循环区间长度
        // 二重循环遍历数组
        for(int len = 1; len <= n; len++){
            for(int i = 1; i + len - 1 <= n; i++){
                int j = i + len - 1;
                // `k` 遍历`[i,i + len - 1]`，保存最大值。
                for(int k = i; k <= j; k++){
                    //`dp[i][k - 1] + dp[k + 1][j]`表示`[i,k - 1]`与`[k + 1, j]`被戳破所获得的最大coins数，`s[i - 1] * s[k] * s[j + 1]`表示最后戳破第k个气球所获得coins数目。
                    dp[i][j] = Math.max(dp[i][j],
                                        dp[i][k - 1] + dp[k + 1][j] + s[i - 1] * s[k] * s[j + 1]);
                }
            }
        }
        return dp[1][n];
    }
}
