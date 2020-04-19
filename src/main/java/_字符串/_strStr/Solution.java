package _字符串._strStr;

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


}
