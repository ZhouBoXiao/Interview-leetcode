package _sortByNumber._0_100._29两数相除;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/9 16:17
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = (dividend ^ divisor) < 0 ;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if (t >> i >= d) { // t / (i ^ 2 ) >= d
                t -= d << i; // t -= (i ^ 2) * d
                result += 1<<i;
            }
        }
        return negative ? -result : result;
    }
}
