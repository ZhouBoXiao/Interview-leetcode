package _sortByNumber._501_600._554_砖墙;

import java.util.*;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/19 16:55
 */
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> lis : wall) {
            int sum = 0;
            for (int i = 0; i < lis.size() - 1; i++) {
                sum += lis.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int result = 0;
        for (int a  : map.keySet()) {
            result = Math.max(result, map.get(a));
        }
        return wall.size() - result;
    }
}
