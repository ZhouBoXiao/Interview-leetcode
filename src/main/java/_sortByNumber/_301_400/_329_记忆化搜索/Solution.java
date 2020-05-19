package _sortByNumber._301_400._329_记忆化搜索;

/***
 * 矩阵中的最长递增路径
 */
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        //1.判断是否访问过，2.存储当前格子的最长递增长度
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, dfs(matrix, Integer.MIN_VALUE, dp, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int pre, int[][] dp, int i, int j) {
        if (i < 0 || i > matrix.length || j < 0 || j > matrix[0].length || pre >= matrix[i][j]) {
            return 0;
        }
        //如果有数据，直接返回
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int max = 0 ;
        max =  Math.max(max, dfs(matrix, matrix[i][j], dp, i+1, j));
        max =  Math.max(max, dfs(matrix, matrix[i][j], dp, i-1, j));
        max =  Math.max(max, dfs(matrix, matrix[i][j], dp, i, j+1));
        max =  Math.max(max, dfs(matrix, matrix[i][j], dp, i, j-1));
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}
