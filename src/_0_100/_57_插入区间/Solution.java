package _0_100._57_插入区间;

import java.util.*;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int index = 0, n = intervals.length;
        while (index < n && newInterval[0] > intervals[index][1]) {
            res.add(intervals[index++]);
        }
        int[] temp = new int[]{newInterval[0], newInterval[1]};
        while (index < n && newInterval[1] >= intervals[index][0]) {
            temp[0] = Math.min(intervals[index][0], temp[0]);
            temp[1] = Math.max(intervals[index][1], temp[1]);
            index++;

        }
        res.add(temp);
        while (index < n) {
            res.add(intervals[index++]);
        }

        return res.toArray(new int [0][]);
    }
}
