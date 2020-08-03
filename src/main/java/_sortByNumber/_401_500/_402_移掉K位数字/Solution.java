package _sortByNumber._401_500._402_移掉K位数字;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/24 22:20
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : num.toCharArray()) {
            while (sb.length() !=0 && sb.charAt(sb.length() - 1) > ch && k != 0) {
                sb.deleteCharAt(sb.length() - 1);
                k --;
            }
            sb.append(ch);
        }
        while (k-- > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') i++;
        if (i == sb.length()) return "0";
        else return sb.substring(i);
    }

    public String removeKdigits1(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : num.toCharArray()) {

            while (sb.length() != 0 && sb.charAt(sb.length() - 1) < ch && k!=0){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(ch);
        }
        while (k-- >0) sb.deleteCharAt(sb.length() - 1);
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') i++;
        if (i == sb.length()) return "0";
        else return sb.substring(i);
    }
}
