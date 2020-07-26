package _sortByNumber._0_100._38_外观数列;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/26 21:31
 */
public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            String ns = new String();
            for (int j = 0; j < s.length(); ) {
                int k = j;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) k++;
                ns += (k - j) + "" + s.charAt(j);
                j = k;
            }
            s = ns;
        }
        return s;
    }
}
