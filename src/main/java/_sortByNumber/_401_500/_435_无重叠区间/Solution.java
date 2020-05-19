package _sortByNumber._401_500._435_无重叠区间;

import java.util.Arrays;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int start = 0;
        int end = intervals[0][1];
        int num = 0;
        for (int i = 1; i < intervals.length; i++) {
            start = intervals[i][0];
            if (start < end) {
                num++;

            } else {
                end = intervals[i][1];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,100},
                {11,22},
                {1,11},
                {2,12}
        };
        System.out.println(new Solution().eraseOverlapIntervals(intervals));
    }
}
