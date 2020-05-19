package _sortByNumber._0_100._76;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        int sLen = s.length();
        int tLen = t.length();
        int min = Integer.MAX_VALUE;
        HashMap<Character, Integer> windows = new HashMap<Character, Integer>();
        HashMap<Character, Integer> needs = new HashMap<Character, Integer>();
        for (int i = 0; i < tLen; i++) {
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i),0) + 1);
        }
        int count = tLen;
        int start = 0;
        int right = 0, left = 0, match = 0;
        while (right < sLen) {
            char ch = s.charAt(right);
            if (needs.getOrDefault(ch, 0) > 0) {
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                if (windows.get(ch).equals(needs.get(ch))) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left < min) {
                    start = left;
                    min = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.getOrDefault(c2, 0) > 0) {
                    windows.put(c2, windows.get(c2) -  1);
                    if (windows.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }

        }
        return min == Integer.MAX_VALUE ?
                "" : s.substring(start, start + min);

    }
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
