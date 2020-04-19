package _公司笔试.leetcode._1;

import java.util.Arrays;
import java.util.*;

public class Solution {
    //int res = 0;
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {

        int[] res = new int[requirements.length];
        Arrays.fill(res, -1);
        int[][] day = new int[increase.length + 1][3];
        for (int i = 1; i < increase.length; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }
        System.arraycopy(increase, 0, day, 1, increase.length);

        for (int i = 0; i < requirements.length ; i++) {

            int j = left_bound(day, requirements[i]);
            if (j != -1) {
                res[i] = j;
            }
        }

        return res;
    }

    boolean ok (int[] a, int[] b) {
        if (a[0] >= b[0] && a[1] >= b[1] && a[2] >= b[2]) {
            return true;
        }
        return false;
    }

   //               increase  >= requirement
    int left_bound(int[][] nums, int[] target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2 ;
            if (nums[mid][0] >= target[0]) {
                if (ok(nums[mid], target)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid][0] < target[0]) {

                left = mid + 1;
            }

        }

        if (left >= nums.length || !ok(nums[left], target))
            return -1;
        return left;
    }

    public static void main(String[] args) {
        int[][] increase  = new int[][] {
                {2,8,4},{2,5,0},{10,9,8}
        };
        int[][] requirements   = new int[][] {
                {2,11,3},{15,10,7},{9,17,12},{8,1,14}
        };
//        int[][] increase  = new int[][] {
//                {0,4,5},{4,8,8},{8,6,1},{10,10,0}
//        };
//        int[][] requirements   = new int[][] {
//                {12,11,16},{20,2,6},{9,2,6},{10,18,3},{8,14,9}
//        };
        System.out.println(new Solution().getTriggerTime( increase, requirements));
    }
}
