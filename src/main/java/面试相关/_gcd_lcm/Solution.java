package 面试相关._gcd_lcm;

public class Solution {
    int gcd (int a, int b) {
        return b == 0 ? a : gcd(b ,a % b);
    }
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
