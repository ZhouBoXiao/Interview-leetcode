package _题型分类._字符串._227基本计算器2;

import java.util.Stack;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/9 21:58
 */
public class Solution {
    public int calculate(String s) {
        int res = 0, d= 0;
        char sign = '+';
        Stack<Integer> nums = new Stack<>();
        for (int i =0 ; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0') {
                d = d * 10 - '0' + cur;
            }
            if ( (cur < '0' && cur != ' ') || i == s.length() - 1 ) {
                switch(sign) {
                    case '+' : nums.push(d); break;
                    case '-' : nums.push(-d); break;
                    case '*' : nums.push(nums.pop() * d); break;
                    case '/' : nums.push(nums.pop() / d); break;
                }
                sign = cur;
                d = 0;
            }
        }
        while (!nums.isEmpty()) {
            res += nums.pop();
        }
        return res;
    }
}
