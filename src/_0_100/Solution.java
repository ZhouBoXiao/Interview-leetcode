package _0_100;

public class Solution {
    public boolean isMatch(String s, String p) {

        if (p==null||p.isEmpty())return s==null||s.isEmpty();
        int i=0,j=0,istart=-1,jstart=-1,slen=s.length(),plen=p.length();
        //判断s的所有字符是否匹配
        while (i<slen) {
            //三种匹配成功情况以及匹配失败返回false
            if (j < plen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < plen && p.charAt(j) == '*') {
                istart = i;
                jstart = j++;
            } else if (istart > -1) {
                i = ++istart;
                j = jstart + 1;
            } else {
                return false;
            }
        }
        while (j<plen&&p.charAt(j)=='*')j++;
        return j==plen;
    }

    public static void main(String[] args) {
        new Solution().isMatch("aa", "a");
    }
//    public boolean isMatch(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//
//        // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
//        boolean[][] dp = new boolean[m + 1][n + 1];
//
//        // 初始化
//        dp[0][0] = true;
//        for (int i = 1; i <= n; i++) {
//            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else if (p.charAt(j - 1) == '*') {
//                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
//                }
//            }
//        }
//
//        return dp[m][n];
//    }
}
