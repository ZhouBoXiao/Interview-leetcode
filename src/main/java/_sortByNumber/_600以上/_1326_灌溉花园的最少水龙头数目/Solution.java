package _sortByNumber._600以上._1326_灌溉花园的最少水龙头数目;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/19 14:32
 */
public class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] intervals = new int[n+1][2];
        for (int i = 0; i < n+1; i++) {
            intervals[i][0] = Math.max(0, i - ranges[i]);
            intervals[i][1] = Math.min(n, i + ranges[i]);
        }
        Arrays.sort(intervals, (a,b)->{
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int index = 0, c = 0, res = 0;
        while (c < n) {

            if (intervals[index][0] > c) {
                return -1;
            }
            int max = 0;
            while (index <= n && intervals[index][0] <= c) {
                max = Math.max(max, intervals[index][1]);
                index++;
            }
            res ++;
            c = max;

        }
        return res;
    }

    public int minTaps1(int n, int[] ranges) {
        int[] tail = new int[n+1];
        Arrays.fill(tail, -1);

        for(int i = 0; i <= n; i++){
            int curr = Math.max(0, i-ranges[i]);
            int target = Math.min(n, i+ranges[i]);
            tail[curr] = Math.max(tail[curr], target);
        }
        int count = 0;
        int currhop = 0;
        int nexthop = tail[0];
        for(int i = 0; i <= n; i++){
            if(i > currhop){
                if(i > nexthop){
                    return -1;
                }
                count++;
                currhop = nexthop;
            }
            nexthop = Math.max(nexthop, tail[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution().minTaps1(5, new int[]{3,4,1,1,0,0});
    }
}
