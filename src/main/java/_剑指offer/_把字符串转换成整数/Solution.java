package _剑指offer._把字符串转换成整数;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 11:29
 */
public class Solution {
    public int strToInt(String str) {
        int index = 0;
        if (str.length() == 0) return 0;
        str = str.trim();
        //1.remove space
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        boolean flag = true;
        if (index < str.length()&&( str.charAt(index) == '+' || str.charAt(index) == '-')) {

            flag = str.charAt(index) != '-';
            index++;
        }
        if (index < str.length() && (str.charAt(index) < '0' || str.charAt(index) > '9')) {
            return 0;
        }
        long sum = 0;
        for (;index < str.length(); index++) {

            int cur = str.charAt(index) - '0';
            if (cur< 0 || cur > 9) break;
            sum = sum * 10 + cur;

            if(sum > Integer.MAX_VALUE){
                return flag ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }


        }
        return flag ? (int)sum : -(int)sum;
    }
}