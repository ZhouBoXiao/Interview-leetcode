package _sortByNumber._301_400._347_前K个高频元素;

import java.util.*;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/7 23:11
 */

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, v) -> v = v == null ? 1 : v + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (heap.size() < k) heap.add(key);
            else if (map.get(key) > map.get(heap.peek())) {
                heap.poll();
                heap.add(key);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
