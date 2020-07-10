package _公司笔试.leetcode._196;

import java.util.Arrays;

/**
 * @Description:
 * @Author:boxiao
 * @Date: 2020/7/5 10:38
 */
public class Solution {
    /**统计01矩阵中全1子矩阵的个数
     * 枚举矩阵的下边界，对于每个下边界，统计所有宽极大的矩形的答案（高度可以用差分）。n2 统计完之后，我们已知所有高度的宽极大的答案，
     * @param mat
     * @return
     */
    public int numSubmat(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length;
        int[][] f = new int[n][m];
        int[] a = new int[n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++) {
                f[i][j] = (j == 0 ? 0 : f[i][j - 1]) + mat[i][j];
            }
        int ans = 0;
        for (int i = 0; i < m; i ++)
            for (int j = i; j < m; j ++) {
                for (int k = 0; k < n; k ++) {
                    int tmp = f[k][j] - (i == 0 ? 0 : f[k][i - 1]);
                    if (tmp == j - i + 1) a[k] = 1;
                    else a[k] = 0;
                }
                for (int k = 0; k < n; k ++) {
                    if (a[k] == 0) continue;
                    int tmp = k;
                    while (tmp < n && a[tmp]!=0) ++ tmp;
                    -- tmp;
                    int sz = tmp - k + 1;
                    ans += sz * (sz + 1) / 2;
                    k = tmp;
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubmat(new int[][]{
                {1,0,1},
                {0,1,0},
                {1,0,1}
        }));
    }
}
