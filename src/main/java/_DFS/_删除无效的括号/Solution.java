package _DFS._删除无效的括号;

import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if ("()".equals(s) || "".equals(s)) {
            result.add(s);
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.offer(s);
        boolean isFound = false;    //判断是否找到了有效字符串

        while (!queue.isEmpty()) {

            String cur = queue.poll();
            if (isVaild(cur)) {
                result.add(cur);
                //在这一层出结果了，下一层就不会出结果，下下层才会出结果
                isFound = true;
            }
            if (isFound) continue;

            for (int i = 0; i < cur.length() ; i++) {
                if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                    String str;
                    if (i == cur.length() - 1) {
                        str = cur.substring(0, cur.length() - 1);
                    } else {
                        str = cur.substring(0, i) + cur.substring(i + 1);
                    }
                    //如果集合中还未有该字符串
                    if (set.add(str)) {
                        queue.offer(str);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add("");
        }
        return result;

    }
    private boolean isVaild(String s) {
        int left = 0;

        for (int i = 0 ; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')'){
                if (left!=0) {
                    left--;
                } else {
                    return false;
                }
            }
        }
        return left == 0;
    }

    public static void main(String[] args) {
        new Solution().removeInvalidParentheses("(a)())()");
    }

}
