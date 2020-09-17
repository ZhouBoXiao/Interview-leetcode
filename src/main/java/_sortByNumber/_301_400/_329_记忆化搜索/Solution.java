package _sortByNumber._301_400._329_记忆化搜索;

/***
 * 矩阵中的最长递增路径
 */
public class Solution {


    int[][] dir = new int[][]{{0,1},{0, -1}, {1, 0}, {-1, 0}};
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
                max = Math.max(max, dfs(matrix, Integer.MIN_VALUE,  i, j, dp));
            }
        }
        return max;

    }

    int dfs(int[][] matrix, int pre,  int x, int y, int[][] dp) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || pre >= matrix[x][y]) {
            return 0;
        }
        //如果有数据，直接返回
        if (dp[x][y] != 0) return dp[x][y];
        int max = 0;

        for (int i = 0; i < 4; i++) {
            int dx = dir[i][0] + x;
            int dy = dir[i][1] + y;
            max = Math.max(max, dfs(matrix, matrix[x][y], dx, dy, dp));
        }

        dp[x][y] = max + 1;
        return dp[x][y];
    }
}
