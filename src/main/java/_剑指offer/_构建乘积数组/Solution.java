package _剑指offer._构建乘积数组;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 20:47
 */
public class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= a[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }

    public static void main(String[] args) {
        new Solution().constructArr(new int[]{1,2,3,4,5});
    }
}
