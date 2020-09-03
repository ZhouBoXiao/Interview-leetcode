package _题型分类._字符串._大数相加;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/3 13:22
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, c = 0;
        while (c >= 0 || i >= 0 || j >= 0) {
            if (i >= 0) c += num1.charAt(i--) - '0';
            if (j >= 0) c += num2.charAt(j--) - '0';
            sb.append(c%10);
            c/=10;
        }
        return sb.reverse().toString();
    }
}
