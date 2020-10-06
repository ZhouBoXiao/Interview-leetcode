package _题型分类._字符串._1247_交换字符使得字符串相同;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/19 16:23
 */
public class Solution {
    public int minimumSwap(String s1, String s2) {
        int x = 0, y = 0, n = s1.length();
        for (int i = 0; i < n ; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') x++;
                else y++;
            }
        }
        return (x + y) % 2 == 1 ? -1 : (x + 1)/2 + (y + 1)/2;
    }
}
