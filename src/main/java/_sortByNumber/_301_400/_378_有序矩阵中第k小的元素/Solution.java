package _sortByNumber._301_400._378_有序矩阵中第k小的元素;

public class Solution {
    int n = 0;

    public int kthSmallest(int[][] matrix, int k) {
        n = matrix.length;
        // 找到mid
        // 如果有比mid小的个数 > k, 继续往
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            int p = partition(matrix, mid);
            if (p >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 找到比mid小的个数, 从i,j  matrix[i][j];
    int partition(int[][] matrix, int mid) {
        int cnt = 0;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                j++;
                // 第j列有i+1个元素<=mid
                cnt += i + 1;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return cnt;
    }

}
