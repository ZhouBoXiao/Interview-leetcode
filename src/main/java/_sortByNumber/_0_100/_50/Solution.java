package _sortByNumber._0_100._50;

public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        double cur = x;

        for ( long i = N ; i > 0 ;) {
            if (i % 2 ==1) {
                ans *= cur;
            }
            cur = cur * cur;
            i >>= 1;
        }

        return ans;
    }
}
