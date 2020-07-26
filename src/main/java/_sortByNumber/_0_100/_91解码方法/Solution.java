package _sortByNumber._0_100._91解码方法;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/25 17:01
 */
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1;i <= n; i++) {
            if (s.charAt(i-1)!='0') dp[i] += dp[i-1];
            if (i >= 2) {
                int t = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
                if (t >= 10 && t  <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }
}
