package _题型分类._字符串._简化路径;

import java.util.Stack;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/2 12:39
 */
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        int left = 0 , right = path.length() - 1;
//        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] strs = path.split("/+");
        for (int i = 1; i < strs.length; i++) {
            if ("..".equals(strs[i])){
                if (sb.length() > 0) {
                    for (int j = sb.length() - 1; j >= 0 ; j--) {
                        if (sb.charAt(j) == '/') {
                            sb.delete(j, sb.length());
                            break;
                        }
                    }
                }
            } else if (".".equals(strs[i])){
                continue;
            } else {
                sb.append("/").append(strs[i]);
            }
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/../"));
    }
}
