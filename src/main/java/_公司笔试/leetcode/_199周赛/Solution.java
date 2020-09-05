package _公司笔试.leetcode._199周赛;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/5 18:51
 */
public class Solution {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] chs = new char[n];
        for (int i = 0 ; i < n; i++) {
            chs[indices[i]] = s.charAt(i);
        }
        return new String(chs);
    }


    public int minFlips(String target) {
        int ans = 0;
        int n = target.length();
        if (target.charAt(0) == '1') ans++;
        for (int i = 0; i < n - 1; i++) {
            if (target.charAt(i) != target.charAt(i + 1)) ans++;
        }
        return ans;
    }




    public static void main(String[] args) {
        new Solution().minFlips("10111");
    }

}
