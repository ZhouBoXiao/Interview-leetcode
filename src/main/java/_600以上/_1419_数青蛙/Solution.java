package _600以上._1419_数青蛙;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/29 19:41
 */
public class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int cnt = 0;
        int max = 0;
        if (croakOfFrogs.charAt(croakOfFrogs.length() - 1) != 'k') return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
            if (ch == 'c') {
                if (map.getOrDefault('k',0) == 0 ) {
                    cnt++;
                } else {
                    if (map.getOrDefault(ch, 0) > map.getOrDefault('k', 0) + 1) {
                        cnt++;
                    }
                }
            } else if (ch == 'r') {
                if (map.getOrDefault(ch, 0) > map.getOrDefault('c', 0)) {
                    return -1;
                }
            } else if (ch == 'o') {
                if (map.getOrDefault(ch, 0) > map.getOrDefault('r', 0)) {
                    return -1;
                }
            } else if (ch == 'a') {
                if (map.getOrDefault(ch, 0) > map.getOrDefault('o', 0)) {
                    return -1;
                }
            } else if (ch == 'k') {
                if (map.getOrDefault(ch, 0) > map.getOrDefault('a', 0)) {
                    return -1;
                }
                max = Math.max(max, cnt);
                cnt -= 1;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOfFrogs("crocakcroraoakccrkrooakacroakk"));
                        //                                                cro ak         cr  o ak
                                                                    //       c   ro a  kc   r o  a     k
                                                                //              c  r oa    k      croak
    }
}
