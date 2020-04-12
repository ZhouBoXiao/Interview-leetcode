package 面试相关._模运算;

public class Solution {
    /**
     * 快速模运算
     * @param x
     * @param n
     * @param mod
     * @return
     */
    long modPow(long x, long n, long mod) {
        long res = 1;
        while (n > 0) {
            if ((n & 1 )!= 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().modPow(100, 100, 6));
    }
}
