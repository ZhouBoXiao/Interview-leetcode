package _501_600._516;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n==0) return 0;
        char[] str = s.toCharArray();
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;++i) dp[i][i] = 1;
        int max = 1;
        for(int i = 1;i<n;++i){
            for(int j = i-1;j>=0;--j){
                if(str[i]==str[j]) {
                    dp[i][j] = dp[i-1][j+1]+2;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }

        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        new Solution().longestPalindromeSubseq("bbbab");
    }
}
