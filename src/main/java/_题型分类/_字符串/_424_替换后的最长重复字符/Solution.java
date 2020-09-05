package _题型分类._字符串._424_替换后的最长重复字符;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/5 17:17
 */
public class Solution {
    public int characterReplacement(String s, int k) {

        int[] letter = new int[26];
        int max = 0, left = 0;
        int index = 0;
        for (int right = 0; right < s.length(); right++) {
            index = s.charAt(right) - 'A';
            letter[index]++;
            max = Math.max(max, letter[index]);
            if (right - left + 1 > max + k) {

                index = s.charAt(left);
                letter[index]--;
                left++;
            }

        }
        return s.length() - left;
    }
}
