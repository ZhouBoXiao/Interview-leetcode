package _401_500._452_用最少数量的箭引爆气球;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] intervals) {
        if (intervals == null || intervals.length == 0 ) {
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
        int num = 1;
        for (int i = 1; i < intervals.length; i++) {
            start = intervals[i][0];
            if (start > end) {

                num++;
                end = intervals[i][1];
            }
        }
        return num;
    }
}
