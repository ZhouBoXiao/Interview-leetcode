package _题型分类._动态规划._背包问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/19 15:48
 */

public class Solution {
    int n,W;
    int[] w,v;

    int[] dp;
    // 0 1 背包
    void solve1() {
        for (int i =  0; i < n ; i++) {
            for (int j = W; j >= w[i] ; j--) {

                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[W]);
    }

    // 完全背包

    void solve2() {
        int m = 0;
        for (int i =  0; i < n ; i++) {
            for (int j = w[i]; j <= m ; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[W]);
    }


    // 多重背包
    void solve3() {

        int s = 0, m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 1; k <= s && k * w[i] <= j ; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * w[i] ] + k * v[i] );
                }
            }
        }
        System.out.println(dp[m]);
    }

    // 多重背包 ( 二进制优化)
    List<int[]> list = new ArrayList<>();
    void solve4() {
        int s = 0, m = 0;
        for (int i = 0; i < n; i++) {
            int v = 0, w = 0; // cin>>v>>w>>s;
            for (int k = 1; k <= s ; k *= 2) {
                s -= k;
                list.add(new int[]{v * k, w * k});
            }
            if (s > 0) list.add(new int[]{v * s, w * s});
        }
        for (int[] l : list) {
            for (int j = m; j >= l[1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - l[1]] + l[0]);
            }
        }
        System.out.println(dp[m]);
    }

    //混合背包
    void solve5() {
        int  m = 0;
        for (int i = 0; i < n; i++) {
            int v = 0, w = 0, s = 0; // cin>>v>>w>>s;
            if (s < 0)  list.add(new int[]{-1, v , w });
            else if (s == 0) list.add(new int[]{0, v, w});
            else {
                for (int k = 1; k <= s; k *= 2) {
                    s -= k;
                    list.add(new int[]{-1, v * k, w * k});
                }
                if (s > 0) list.add(new int[]{-1, v * s, w * s});
            }
        }
        for (int[] l : list) {
            if (l[0] == -1) {
                for (int j = m; j >= l[2]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - l[2]] + l[1]);
                }
            } else {
                for (int j = l[2]; j <= m ; j++) {
                    dp[j] = Math.max(dp[j], dp[j - l[2]] + l[1]);
                }
            }

        }
        System.out.println(dp[m]);
    }

    // 二维费用的背包问题
    void solve6() {
        int m = 0, v = 0;
        int[][] f = new int[0][];
        // cin>>n>>v>>m;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0, c = 0; // cin>>a>>b>>c;
            for (int j = v; j >= a ; j--) {
                for (int k = m; k >= b; k--) {
                    f[j][k] = Math.max(f[j][k], f[j - a][k - b] + c);
                }
            }
        }
        System.out.println(f[v][m]);

    }
    // 分组背包
    void solve7() {

        int s = 0, m = 0;
        for (int i = 0; i < n; i++) {
            int[] w = new int[s];
            int[] v = new int[s];
            for (int j = W; j >= 0 ; j--) {
                for (int k = 0; k < s ; k++) {
                    if (j >= w[k]) dp[j] = Math.max(dp[j], dp[j - w[k]] +  v[k]);
                }
            }
        }
        System.out.println(dp[m]);
    }




    public static void main(String[] args) {

    }
}
