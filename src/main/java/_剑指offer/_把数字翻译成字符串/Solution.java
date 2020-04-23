package _剑指offer._把数字翻译成字符串;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int translateNum1(int num) {
        if (num<=9) {return 1;}
        //获取输入数字的余数，然后递归的计算翻译方法
        int ba = num%100;
        //如果大于9或者大于26的时候，余数不能按照2位数字组合，比如56，只能拆分为5和6；反例25，可以拆分为2和5，也可以作为25一个整体进行翻译。
        if (ba<=9||ba>=26) {return translateNum1(num/10);}
        else  {return translateNum1(num/10)+translateNum1(num/100);}
    }
    public int translateNum2(int num) {

        String str = String.valueOf(num);

        //char[] arr = str.toCharArray();

        int[] dp= new int[str.length()+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=str.length();i++){
            String tmp = str.substring(i-2,i);
            if(Integer.valueOf(tmp)>=10&&Integer.valueOf(tmp)<=25)
                dp[i]=dp[i-1]+dp[i-2];
            else
                dp[i]=dp[i-1];

        }

        return dp[str.length()];

    }
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

}
