package _sortByNumber._0_100._3_无重复字符的最长子串;

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

        int[] index = new int[128];
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, index[s.charAt(i)]);
            maxLen = Math.max(maxLen, i - left + 1);
            index[s.charAt(i)] = i + 1;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring1("abcabcbb"));
    }
}
