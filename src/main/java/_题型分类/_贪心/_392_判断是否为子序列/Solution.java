package _题型分类._贪心._392_判断是否为子序列;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/2 12:46
 */
public class Solution {
    public boolean isSubsequence1(String s, String t) {
        int index  = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : s.toCharArray()) {
            while (i < t.length() && t.charAt(i) != c) i++;
            i++;
        }
        return i <= t.length() ? true : false;
    }

}
