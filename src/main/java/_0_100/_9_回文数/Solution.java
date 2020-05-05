package _0_100._9_回文数;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/5 10:39
 */
public class Solution {

    public boolean isPalindrome1(int x) {
        if (x < 0 )return false;
        int rem = 0, y = 0;
        int q = x;
        while (q!=0) {
            y = y * 10 + q %10;
            q /= 10;
        }
        return y == x;

    }

    public boolean isPalindrome(int x) {
        String s = new StringBuilder(String.valueOf(x)).reverse().toString();
        return s.equals(String.valueOf(x));

    }

}
