package _0_100._57;

import java.util.*;

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
