package _公司笔试._阿里笔试_0717;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/19 18:22
 */
public class Solution {
    /**
     *
     * 题目1:给定一个数x，数据对 (a, b)使得a ^ b ^ x能达到最大，求使|a - b|最小的方案总数有多少。
     * x,a,b的范围都是0 - （2^31 次方-1）
     *
     * 0 -> 2, 100 -> 16
     *
     *
     * 第一题，可知x^a^b=INT_MAX,就是除去符号位每一位都是1,遍历x的每个bit，如果是1，那么a,b在此位的bit必相等，
     * 因为1^1^1=1,1^0^0=1，而相等的话对它们的差就没有贡献了，所以0、1皆可，方案数*2。对于bit为0的情况，
     * 差值取最小的话是确定的。最后由于绝对值的对称性*2。特殊情况x=INTMAX，此时x的每一位已经全是1了，
     * 所以a-b取最小其实就是所有a=b，方案数INT-MAX + 1,用long存储输出
     */
    void solution1() {
        int n, x;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        while (n-- > 0) {
            x = scanner.nextInt();
            long res = 2;
            for (int i = 0; i < 32; ++i) {
                if (((x >> i) & 1) != 0) {
                    res *= 2;
                }
            }
            if (x == Integer.MAX_VALUE) {
                System.out.printf("%ld\n", res / 2);
            } else {
                System.out.printf("%ld\n", res);
            }
        }
        scanner.close();

    }

    /**
     *
     * 第二题：卖粽子（典型的背包问题）
     * 小明要卖粽子，有m种粽子，n克面粉，多种馅料，求做出的粽子能够卖出价格最大是多少？
     * 给定 a[] , b[], c[], d[]
     * 其中a[i] 表示第 i 种粽子，现有馅料数目
     * b[i]表示第 i 种粽子，消耗多少馅料
     * c[i] 表示第 i 种粽子，消耗多少面粉
     * d[i] 表示第 i 种粽子，可以卖多少钱
     * ps：c[0] d[0] 表示不带陷的粽子要多少面粉，和值多少钱
     */
    class Node{
        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        int v, w;
    }
    void solution2() {
        int a, b, c, d;
        int n, m, c0, d0;
        int N = 1010;

        int[] dp = new int[N];
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();m = scanner.nextInt();c0 = scanner.nextInt();d0 = scanner.nextInt();
        List<Node> ns = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            a = scanner.nextInt();b = scanner.nextInt();c = scanner.nextInt();d = scanner.nextInt();
            int cnt = a / b, k = 1;
            while (cnt > 0) {
                if (cnt >= k) {
                    ns.add(new Node(k * c, k * d));
                    cnt -= k;
                    k *= 2;
                } else {
                    ns.add(new Node(cnt * c, cnt * d));
                    cnt = 0;
                }
            }
        }
        for (int i = 0; i < ns.size() + 1; ++i) {
            if (i == ns.size()) {
                for (int j = c0; j <= n; ++j) {
                    /**
                     * dp[j] = max(dp[j], dp[j - c0] + d0)
                     */
                    dp[j] = Math.max(dp[j], dp[j - c0] + d0);
                }
            } else {
                /**
                 * dp[j] = max(dp[j], dp[j - ns[i].v] + ns[i].w)
                 * dp[j]  j 个面粉可以产生的最大价值
                 *
                 */
                for (int j = n; j >= ns.get(i).v; --j) {
                    dp[j] = Math.max(dp[j], dp[j - ns.get(i).v] + ns.get(i).w);
                }
            }
        }
        System.out.println(dp[n]);
        scanner.close();
    }
}
