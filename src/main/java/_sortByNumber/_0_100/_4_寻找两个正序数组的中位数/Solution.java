package _sortByNumber._0_100._4_寻找两个正序数组的中位数;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/7 13:08
 */
public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int left = (m + n + 1) /2;
        int right = ( m+ n + 2) /2;
        return (findKth(A, 0, B, 0 , left) + findKth(A, 0 , B, 0, right)) / 2.0;
    }
    public int findKth(int[] A, int i , int[] B, int j, int k ) {
        if (i >= A.length) return B[j + k  - 1];
        if (j >= B.length) return A[i+k-1];
        if (k == 1) {
            return Math.min(A[i], B[j]);
        }
        int midVal1 = (i + k/2 - 1 < A.length) ? A[i+k/2-1] : Integer.MAX_VALUE;
        int midVal2 = (j + k/2 - 1 < B.length) ? B[j+k/2-1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(A, i + k/2, B, j ,k - k/2);
        } else {
            return findKth(A, i , B, j + k/2,k - k/2);
        }
    }
}
