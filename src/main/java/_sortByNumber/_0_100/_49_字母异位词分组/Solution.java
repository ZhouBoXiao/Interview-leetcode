package _sortByNumber._0_100._49_字母异位词分组;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/27 19:03
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            List<String> list = map.get(key);
            list.add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagarams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            map.computeIfAbsent(key, it -> new ArrayList<>()).add(key);
        }
        return new ArrayList<>(map.values());
    }
}
