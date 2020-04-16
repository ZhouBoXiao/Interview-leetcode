package _101_200._120;

import java.util.*;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        // 只需要记录每一层的最小值即可
        int[] dp = new int[triangle.size()+1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
                dp[j] = Math.min(dp[j],dp[j+1]) + curTr.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {

        int[][] a = new int[][]{{2}, {3,4} ,{6,5,7} ,{4,1,8,3}};
//        List triangle = Arrays.asList(a);

        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3,4));
        triangle1.add(Arrays.asList(6,7,5));
        triangle1.add(Arrays.asList(4,1,8,3));

        System.out.println(new Solution().minimumTotal(triangle1));
    }
}