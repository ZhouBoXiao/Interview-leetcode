package _剑指offer._数值的整数次方;

public class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        int m = n>0?n:-n;   //让m取n的绝对值，这样m一定是大于0的

        while(m!=0){
            if((m&1) != 0){
                res *= x;
            }
            x *= x;
            m >>>= 1;
        }
        return n>0?res:1.0/res;
    }

    public static void main(String[] args) {
        new Solution().myPow(2,10);
    }
}
