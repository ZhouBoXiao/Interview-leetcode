package _题型分类._字符串._strStr;

import java.util.Arrays;

public class Solution {
    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) pn++;
            int curLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                curLen++;
                pL++;
                pn++;
            }
            if (curLen == L) return pn - curLen;
            pn = pn - curLen + 1;
        }
        return -1;
    }

    int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        //文本指针i用来指示文本串
        int i = 0, m = haystack.length();
        //模式指针j用来指示模式串
        int j = 0, n = needle.length();
        int[] nextVal = get_next(needle);
        while (i < m && j < n){
            if (j == -1 || needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            } else {
                j = nextVal[j];

            }
        }
        return j == n ? i - j : -1;
    }

    //普通：get_next
    int[] get_next(String pat){
        int n = pat.length();
        int[] next = new int[n+1];
        Arrays.fill(next, -1);
        //(n+1,-1);//这里数;组大小为n+1，要算上pat[n-1]

        int k = -1, j = 0;
        while (j < n) {
            if (k == -1 || pat.charAt(k) == pat.charAt(j)) {
                //k，j指针都右移一位
                ++j;
                ++k;
                next[j] = k;
            } else {
                //后缀指针k回退到next[k]（下标）的位置
                k = next[k];
            }
        }
        return next;
    }

    //优化：get_nextVal
    int[] get_nextVal(String pat){
        int n=pat.length();
        int[] nextVal = new int[n];
        Arrays.fill(nextVal, -1);
        //这里next数组大小为n，已经算上pat[n-1]了
        int k = -1, j = 0;
        while (j < n-1){
            if( k == -1 || pat.charAt(k) == pat.charAt(j)) {
                k++;
                j++;
                if (pat.charAt(j) != pat.charAt(k)) {
                    nextVal[j] = k;
                } else {
                    nextVal[j] = nextVal[k];
                }
            }
            else {
                k = nextVal[k];
            }
        }
        return nextVal;
    }


}
