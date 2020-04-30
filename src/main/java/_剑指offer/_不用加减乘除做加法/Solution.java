package _剑指offer._不用加减乘除做加法;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 21:20
 */
public class Solution {
    public int add(int a, int b) {
        //a^b是不考虑进位的加法
        //a&b<<1是进位
        //一直递归，运算&最终会导致进位为0，递归结束
        return b == 0 ? a: add(a^b, (a&b)<<1);
    }
}
