package _公司笔试._阿里笔试_0717;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/19 18:22
 */
public class Solution {

    void sol2() {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        int N = 1010;
        int[] e = new int[N];
        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];
        int[] d = new int[N];

        int[] dp = new int[N];
        n = scanner.nextInt();m = scanner.nextInt();
        e[0] = n / c[0];
        for (int i = 1; i <= m; ++i){
            a[i] = scanner.nextInt();b[i] = scanner.nextInt();c[i] = scanner.nextInt();d[i] = scanner.nextInt();
            e[i] = Math.min(n / c[i], a[i] / b[i]);
        }
        for (int i = 0; i <= m; i++) {
            for (int j = n; j >= 0 ; j--) {
                for (int k = 0; k <= e[i]; k++) {
                    if (j - k * c[i] >= 0) {
                        dp[j] = Math.max(dp[j], dp[j - k * c[i]] + k * d[i]);
                    }
                }
            }
        }
        System.out.println(dp[n]);
        scanner.close();
    }

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
     *
     * 对于c0,完全背包，对于有馅料的是多重背包
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
                 * dp[j]  j克面粉可以产生的最大价值
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

    /**
     * 一个数轴上有n个超市，用数字表示超市的位置
     * 小明要去m个超市，请问小明能去的所有m个超市，相邻超市的距离的最小值之中的最大值是多少。
     *
     * 举例，超市的位置是：1 2 4 8 9
     * 小明要去3个超市
     * 能取得超市组合为
     *
     * [相邻超市距离最小值 = 1] 1 2 4
     *
     * [相邻超市距离最小值 = 1] 1 2 9
     *
     * [相邻超市距离最小值 = 3] 1 4 8
     *
     * [相邻超市距离最小值 = 3] 1 4 9
     * ....不详细列出了，就是从5个中选3个
     * 所以距离最小值的最大值为3
     */
    void solve3() {
        int[] arr = new int[]{1,2,4,8,9};
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        Arrays.sort(arr);
        int n = arr.length;
        int left = arr[0], right = arr[n-1];
        int res = -1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (can(arr, mid, n, m)) {
                res = Math.max(res, mid);
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(res);

    }
    // 判断以最小距离mid，arr中有m个节点的距离都大于等于mid
    private boolean can(int[] arr, int mid, int n, int m) {
        int pos = arr[0];
        int elements = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - pos >= mid) {
                pos = arr[i];
                elements++;
                if (elements == m) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 给一个字符串S，问以[0, i]的子字符串X，X在S中一共出现几次。
     *
     * 举例：abab
     *
     * a出现2次
     *
     * ab出现2次
     *
     * aba出现1次
     *
     * abab出现1次
     *
     * 所以一共是6次
     *
     * 需要注意的是，不能算重叠字符串
     *
     * 比如aaaaa, aa出现的次数只算2次
     */
    void solve4() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
//        int i = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String x = s.substring(0, i + 1);
            int cur = 0;
            while (s.indexOf(x, cur) > -1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
