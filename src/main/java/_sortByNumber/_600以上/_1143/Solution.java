package _sortByNumber._600以上._1143;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray(), s2 = text2.toCharArray();
        int lenI = s1.length, lenJ = s2.length;
        if (lenI == 0 || lenJ == 0) return 0;

        int[][] dp = new int[lenI + 1][lenJ + 1];
        for (int i = 0; i < lenI; i++) {
            for (int j = 0; j < lenJ; j++) {
                if (s1[i] == s2[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[lenI][lenJ];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        new Solution().longestCommonSubsequence(s1, s2);
    }
}
