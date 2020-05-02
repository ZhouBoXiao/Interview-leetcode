package _公司笔试.leetcode._第25场双周赛._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/2 22:31
 */
public class Solution {
    public int maxDiff(int num) {
        int max = -1;
        int min = -1;

        StringBuilder s = new StringBuilder(num + "");
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != '9') {
                int ch = s.charAt(i);
                s.setCharAt(i, '9');
                for (int j = i +1 ; j < s.length() ; j++) {
                    if (s.charAt(j) == ch)
                        s.setCharAt(j, '9');
                }
                max = Integer.parseInt(s.toString());
                break;
            }

        }
        if (max == -1) max = Integer.parseInt(s.toString());
        StringBuilder str = new StringBuilder(num + "");
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (str.charAt(i) != '1') {
                    int ch = str.charAt(i);
                    str.setCharAt(i, '1');
                    for (int j = i +1 ; j < str.length() ; j++) {
                        if (str.charAt(j) == ch)
                            str.setCharAt(j, '1');
                    }
                    min = Integer.parseInt(str.toString());
                    break;
                }
            } else {
                if (str.charAt(i) != '0' && str.charAt(i) != str.charAt(0)) {
                    int ch = str.charAt(i);
                    str.setCharAt(i, '0');
                    for (int j = i +1 ; j < str.length() ; j++) {
                        if (str.charAt(j) == ch)
                            str.setCharAt(j, '0');
                    }
                    min = Integer.parseInt(str.toString());
                    break;
                }
            }
        }
        if (min == -1) min = Integer.parseInt(str.toString());
        return max- min;
    }

    public static void main(String[] args) {
        new Solution().maxDiff(1919    );
    }
}
