package _0_100._69_x的平方根;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/9 22:29
 */
public class Solution {

    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

    public int mySqrt1(int x) {
        if (x <= 1) return x;
        int max = x;
        int min = 1;
        while (max > min + 1) {
            int mid = (max + min) / 2;
            if ( x/mid < mid) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;
    }
}
