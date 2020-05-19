package _sortByNumber._0_100._85;

import java.util.Arrays;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n]; // initialize left as the leftmost boundary possible
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for(int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            // update left
            for(int j=0; j<n; j++) {
                if(matrix[i][j]=='1') left[j]=Math.max(left[j],cur_left);
                else {left[j]=0; cur_left=j+1;}
            }
            // update right
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                else {right[j] = n; cur_right = j;}
            }
            // update area
            for(int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }
        
    /*public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;

        int[] dp = new int[m];
        int maxn = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxn = Math.max(maxn, solve(dp));
        }
        return maxn;

    }

    private int solve(int[] dp) {

        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(-1);
        int n = dp.length;
        int i = 0;
        int maxn = 0;
        while (i < n) {
            while (stack.getLast() != -1 && dp[stack.getLast()] >= dp[i]) {

                maxn = Math.max(maxn, dp[stack.removeLast()] * (i - 1 - stack.getLast()));
            }

            stack.addLast(i);
            i++;
        }
        while (stack.getLast() != -1) {
            maxn = Math.max(maxn, dp[stack.removeLast()] * (n - 1 - stack.getLast()));
        }
        return maxn;

    }*/

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };

        System.out.println(new Solution().maximalRectangle(matrix));
    }
}
