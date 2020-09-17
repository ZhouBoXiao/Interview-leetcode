package _公司笔试.leetcode._行相等的最少多米诺旋转;

import java.util.*;

public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i],0) + 1);
        }
        for (int i = 0; i < B.length; i++) {
            map1.put(B[i], map1.getOrDefault(B[i],0) + 1);
        }
        int min = Integer.MAX_VALUE;

        for (int k : map.keySet()) {

            int cnt = 0 ;
            for (int  i = 0;  i<  A.length;  i++) {
                if (A[i] != k) {
                    if (B[i] == k) {
                        cnt++;

                    } else {
                        cnt =Integer.MAX_VALUE;
                        break;
                    }
                }
            }

            min = Math.min(min, cnt);
        }

        for (int k : map1.keySet()) {

            int cnt = 0 ;
            for (int  i = 0;  i<  B.length;  i++) {
                if (B[i] != k) {
                    if (A[i] == k) {
                        cnt++;
                    } else {
                        cnt =Integer.MAX_VALUE;
                        break;
                    }
                }
            }
            min = Math.min(min, cnt);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
