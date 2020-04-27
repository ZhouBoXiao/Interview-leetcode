package _0_100._48_旋转图像;

public class Solution {
    public void rotate1(int[][] matrix) {
        int abs1 = 0, abs2 = matrix.length - 1;
        int times = 0;
        while (abs1 <= abs2) {
            int p1 = abs1;
            int p2 = abs2;
            while (p1 != abs2) {
                int temp = matrix[abs1][p1];        //左上
                matrix[abs1][p1] = matrix[p2][abs1];//左上 = 左下
                matrix[p2][abs1] = matrix[abs2][p2];//左下 = 右下
                matrix[abs2][p2] = matrix[p1][abs2];//右下 = 右上
                matrix[p1][abs2] = temp;            //右上 = 左上
                p1++;
                p2--;
            }
            abs1 ++;
            abs2 --;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

}
