package _0_100._7_整数反转;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/5 10:34
 */
public class Solution {
    public int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n *10 + x%10;
            x /=10;
        }
        return (int) n == n ? (int) n : 0;
    }



    public int reverse1(int x) {
        String s = String.valueOf(x);
        char[] chs = s.toCharArray();
        int i = 0, j  = chs.length - 1;
        while (i <= j) {
            if (chs[i] == '-' || chs[i] == '+') i++;
            char ch = chs[i];
            chs[i] = chs[j];
            chs[j] = ch;
            i++;
            j--;
        }
        boolean flag = true;
        boolean sign = true;
        long res = 0;
        for (int i1 =0 ; i1 <  chs.length; i1 ++) {
            if (flag && chs[i1] == '0' ) {
                continue;
            }
            else if (chs[i1] == '-' ) {
                sign = false;
            }
            else if (chs[i1] >= '0' && chs[i1] <= '9') {
                int t = chs[i1] - '0';
                res = res * 10 + t;
                if (sign && res > Integer.MAX_VALUE) return 0;
                if (!sign && -res < Integer.MIN_VALUE) return 0;
                flag = false;
            }
        }
        return sign ? (int)res : -(int)res;
    }
}
