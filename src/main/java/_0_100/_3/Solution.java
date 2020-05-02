package _0_100._3;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i< s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) +1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);

        }
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {

        int n = s.length();
        int[] index = new int[128];
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            left = Math.max(index[s.charAt(right)], left);
            maxLen = Math.max(maxLen, right - left + 1);
            index[s.charAt(right)] = right + 1;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring1("abcabcbb"));
    }
}
