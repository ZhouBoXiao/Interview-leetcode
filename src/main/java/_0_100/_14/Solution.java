package _0_100._14;

import javafx.util.Pair;

public class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int res = 0;
        boolean flag = true;
        int min = Integer.MAX_VALUE;
        String s = "";
        for (int i = 0; i < strs.length; i++) {

            min = Math.min(min, strs[i].length());

        }
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {
                    continue;
                } else if (strs[j].charAt(i) != strs[j-1].charAt(i)) {
                    flag = false;
                    return strs[j].substring(0, i);
                }
            }
        }
        if (flag) {
            return strs[0].substring(0,min);
        }
        return "";
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"cc","cc","c"};

        System.out.println(new Solution().longestCommonPrefix(strs));

    }
}
