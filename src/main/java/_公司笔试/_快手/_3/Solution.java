package _公司笔试._快手._3;

import java.util.*;

public class Solution {
    /**
     * 根据顾客属性计算出顾客排队顺序
     * @param a int整型一维数组 顾客a属性
     * @param b int整型一维数组 顾客b属性
     * @return int整型一维数组
     */
    public int[] WaitInLine (int[] a, int[] b) {

        if (a.length == 0 || b.length == 0) return new int[0];
        int n = a.length;
        int[][] c = new int[n][2];
//        int[] d = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            c[i][0] = a[i] - b[i];
            c[i][1] = b[i] * n - a[i];
//            d[i] =a[i] - b[i] + b[i] * n - a[i];
            map.put(c[i][0] * n + c[i][1], i + 1);
        }
//        Arrays.sort(d);
        Arrays.sort(c, ((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        }));
        int[] res= new int[n];
        for (int i =0 ; i < n; i ++) {
            res[i] = map.get(c[i][0] * n + c[i][1]);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a= new int[]{8,9,7};
        int[] b= new int[]{5,8,3};
        int[] ints = new Solution().WaitInLine(a, b);
        System.out.println();
    }
}
