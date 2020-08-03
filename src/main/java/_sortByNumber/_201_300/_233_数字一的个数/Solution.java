package _sortByNumber._201_300._233_数字一的个数;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/31 20:51
 */
public class Solution {
    public int countDigitOne(int n) {
        if (n < 0) return 0;
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0  || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1 ) * digit;
            low += cur * digit;
            cur = high % 10;
            high/=10;
            digit *= 10;
        }
        return res;
    }
}
