package _公司笔试.leetcode._188周赛._2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/10 10:21
 */
public class Solution {

    public int countTriplets(int[] arr) {
//        Set<String> set = new HashSet<>();

        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = arr.length - 1; k > i; k--) {
                int a = 0;
                int b = 0;
                for (int l = i ; l < i+1; l++) {
                    a ^= arr[l];
                }
                for (int l = i+1; l <= k; l++) {
                    b ^= arr[l];
                }
                if ( a==b) {
                    cnt++;
                }
                for (int j = i + 2; j <= k;j++) {
                    a ^= arr[j];
                    b ^= arr[j];
                    if ( a==b) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    boolean valid(int[] arr, int i, int j, int k) {
        int a = arr[i];
        for (int l = i + 1; l < j; l++) {
            a ^= arr[l];
        }
        int b = arr[j];
        for (int l = j + 1; l <= k; l++) {
            b ^= arr[l];
        }
        return a==b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countTriplets(new int[]{2,3}));
    }
}
