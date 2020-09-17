package _sortByNumber._0_100._28实现strStr;

import java.util.Arrays;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/9 16:18
 */
public class Solution {
    int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int i = 0, m = haystack.length();
        //模式指针j用来指示模式串
        int j = 0, n = needle.length();
        int[] nextVal = get_next(needle);

        while (i < m && j < n) {
            if (j == -1 || needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            } else {
                j = nextVal[j];
            }
        }
        return j == n ? i - j : -1;
    }

    private int[] get_next(String pat) {
        int n = pat.length();
        int[] next = new int[n + 1];
        //(n+1,-1);//这里数;组大小为n+1，要算上pat[n-1];
        Arrays.fill(next, -1);
        int k = -1, j = 0;
        while (j < n) {
            if (k == -1 || pat.charAt(k) == pat.charAt(j)) {
                //k，j指针都右移一位
                k++;
                j++;
                next[j] = k;
            } else {
                //后缀指针k回退到next[k]（下标）的位置
                k = next[k];
            }
        }
        return next;
    }
}
