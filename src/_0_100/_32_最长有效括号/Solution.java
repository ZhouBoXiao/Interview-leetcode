package _0_100._32_最长有效括号;

import java.util.Stack;

public class Solution {

    /*
       public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
     */

    public int longestValidParentheses(String s) {
        int i = 0;
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int maxn = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        while (i < n) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                maxn = Math.max(maxn, i - stack.peek());
            }
            i++;
        }
        return maxn;
    }

    public static void main(String[] args) {

        String s = ")()())";
        System.out.println(new Solution().longestValidParentheses(s));
    }
}
