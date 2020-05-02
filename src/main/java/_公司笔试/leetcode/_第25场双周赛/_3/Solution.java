package _公司笔试.leetcode._第25场双周赛._3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/2 22:31
 */
public class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {

        List<Integer> map1 = new ArrayList<>();
        List<Integer> map2 = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.add((int) s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            map2.add((int) s2.charAt(i));
        }
        Collections.sort(map1);
        Collections.sort(map2);
        int cnt1 = 0 ,cnt2 = 0;
        for (int i = 0 ; i < s1.length(); i++) {
            if (map1.get(i) >= map2.get(i)) {
                cnt1++;
            }
            if (map1.get(i) <= map2.get(i)) {
                cnt2++;
            }
        }
        if (cnt1 == s1.length() || cnt2 == s1.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkIfCanBreak("leetcodee", "interview"));
    }
}
