package _501_600._516;

public class Solution {
    /**
     *dp[i][j]表示s[i..j]代表的字符串的最长回文子序列
     *
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        new Solution().longestPalindromeSubseq("bbbab");
    }
}
