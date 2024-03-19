package 面试相关._n进制转m进制;

import java.util.Stack;

import static java.lang.Math.pow;

public class Solution {

    private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();
    private static String numStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String _10ToN(long tenRadix, int radix)
    {
        // 进制编码支持9+26=35进制
        String code = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder buf = new StringBuilder();
        long remainder = 0;
        while (tenRadix != 0)
        {
            remainder = tenRadix % radix;// 求余数
            tenRadix /= radix;// 除以2
            buf.append(code.charAt((int)remainder));// 保存余数，记得要倒叙排列
        }
        buf.reverse();// 倒叙排列
        return buf.toString();
    }

    long _n26(String s) {
        StringBuilder ss = new StringBuilder(s).reverse();
        long res = 0;
        int radix = 26;
        for (int i = 0 ; i < ss.length(); i++) {
            res += (ss.charAt(i) - 'A') * Math.pow(radix, i);
        }
        return res;
    }

    long stringNTo10(String N_num, int radix) {
        StringBuilder stringBuilder = new StringBuilder(N_num);
        stringBuilder.reverse();// 反转字符
        char bitCh;
        long result = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            bitCh = stringBuilder.charAt(i);
            if (bitCh >= '0' && bitCh <= '9') {
                // '0'对应的ASCII码整数：48
                result += (int) (bitCh - '0') * pow(radix, i);
            } else if (bitCh >= 'A' && bitCh <= 'Z') {
                // 减去'A'的ASCII码值(65),再加上10
                result += ((int) (bitCh - 'A') + 10) * pow(radix, i);
            } else if (bitCh >= 'a' && bitCh <= 'z') {
                // 减去'a'的ASCII码值(97),再加上10
                result += ((int) (bitCh - 'a') + 10) * pow(radix, i);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = solution.stringNTo10("10101010101", 2);
        System.out.println(solution._10ToN(l, 2));

    }
}