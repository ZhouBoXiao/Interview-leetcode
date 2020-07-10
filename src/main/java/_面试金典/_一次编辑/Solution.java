package _面试金典._一次编辑;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/7/6 19:48
 */
public class Solution {
    public boolean oneEditAway1(String first, String second) {
        int len  = first.length() - second.length();
        int count = 1;
        if (len > 1 || len < -1) {
            return false;
        }
        for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                if (len == 1) {
                    j--;
                } else if (len == -1) {
                    i--;
                }
                count--;

            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        int[][] dp = new int[firstLen + 1][secondLen + 1];
        for (int i = 0; i < firstLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < secondLen; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= firstLen; i++) {
            for (int j = 1; j <= secondLen; j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        if (dp[firstLen][secondLen] > 1) {
            return false;
        }
        return true;
    }
}
