package 面试相关._摘苹果;

import java.util.Arrays;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/19 11:07
 */
public class Solution {
    public static long[] pickApples(int[] a, int[] b) {
        // 天数               苹果树数
        int m = b.length, n = a.length;
        long[] res = new long[m];
        // 预排序
        Arrays.sort(a);
        // b 的前缀和
        int sum = 0;
        // 指向苹果数的起点
        int p = 0;
        for (int i = 0; i < m; ++i) {
            sum += b[i];
            // 当天不够的树
            while (p < n && a[p] < sum) {
                // 这棵树减去前几天摘掉的果子，就是今天剩余的果子数， 把剩余的都给摘了
                res[i] += a[p] - (sum - b[i]);
                ++p;
            }
            // 剩下 n-p 就是余量足够的树的个数
            res[i] += (n - p) * b[i];
        }
        return res;
    }

    public static void main(String[] args) {
        pickApples(new int[]{10,20,10}, new int[]{5,7,2});
    }
}
