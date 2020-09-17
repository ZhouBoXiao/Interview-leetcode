package _题型分类._字符串._224_基本计算器;

import java.util.Stack;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/10 9:35
 */
public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res  =0;
        int sign = 1;
        int i = 0;
        while (i <s.length()) {

            int ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int start = i;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) i++;

                res += sign * Integer.parseInt(s.substring(start, i + 1));
            } else if (ch == '+'){
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
