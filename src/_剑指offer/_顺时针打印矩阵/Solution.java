package _剑指offer._顺时针打印矩阵;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return new int[0];
        int m = matrix[0].length;
        int up = 0, down = n - 1;
        int left = 0, right = m - 1;
        int[] res = new int[n * m];
        int index = 0;
        while (true) {
            for (int i = left; i <= right; i++) res[index++] = matrix[up][i];
            if (++up > down) break;
            for (int i = up; i <= down; i++) res[index++] = matrix[i][right];
            if (--right < left) break;
            for (int i = right; i >= left; i--) res[index++] = matrix[down][i];
            if (--down < up) break;
            for (int i = down; i >= up; i--) res[index++] = matrix[i][left];
            if (++left > right) break;
        }
        return res;
    }
}
