package _题型分类._字符串._567_字符串的排列;

import java.util.Arrays;

/**
 * @Description:
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * @Author:boxiao
 * @Data: 2020/5/31 15:28
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int size = s1.length();
        int[] count = new int[26];
        int[] arr = new int[26];
        for (int i = 0; i < size; i++) {
            count[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']++;
        }

        for (int i = size ; i < s2.length(); i++) {
            if (Arrays.equals(count, arr)) return true;
            arr[s2.charAt(i - size) - 'a']--;
            arr[s2.charAt(i) - 'a']++;

        }

        return Arrays.equals(count, arr);
    }
}
