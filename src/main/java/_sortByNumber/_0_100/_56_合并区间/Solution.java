package _sortByNumber._0_100._56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else{
                return a[0] - b[0];
            }
        });
        int[] temp = new int[]{intervals[0][0],intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0] ) {
                temp[0] = Math.min(temp[0], intervals[i][0]);
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                res.add(new int[]{temp[0],temp[1]});
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }
        }
        res.add(new int[]{temp[0],temp[1]});
        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        new Solution().merge(intervals);
    }
}
