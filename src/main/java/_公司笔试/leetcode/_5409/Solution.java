package _公司笔试.leetcode._5409;

import java.net.SocketImpl;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/30 23:05
 */
public class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0 ; i < s.length() - k + 1 ; i++) {
            set.add(s.substring(i,i+k));
        }
        return dfs(set, k, new StringBuilder());
    }

    private boolean dfs(Set<String> set , int k, StringBuilder cur) {

        if (cur.length() == k) {
            String temp = cur.toString();
            if (!set.contains(temp)) {
                return false;
            }
            return true;
        }
        cur.append("0");
        if (!dfs(set, k, cur)) {
            return false;
        }
        cur.deleteCharAt(cur.length() - 1);

        cur.append("1");
        if (!dfs(set, k, cur)) {
            return false;
        }
        cur.deleteCharAt(cur.length() - 1);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hasAllCodes("0110", 2));
    }
}
