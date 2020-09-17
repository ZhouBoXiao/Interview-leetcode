package _题型分类._动态规划._背包问题._多重背包问题;

/**
 * @Description:
 *
 *  有 N 种物品和一个容量是 V 的背包。
 *
 * 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 * @Author: boxiaos
 * @Date: 2020/9/7 19:47
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W = sc.nextInt();
        int w, v, s;
        int[] dp = new int[W + 1];
        for (int i = 0; i < N; i++) {
            w = sc.nextInt();
            v = sc.nextInt();
            s = sc.nextInt();

            for (int j = W; j >= 0 ; j--) {
                for (int k = 1; k <= s && k * w <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * w] + k * v);
                }

            }

        }


        System.out.println(dp[W]);
    }
}

/*
4 5
1 2 3
2 4 1
3 4 3
4 5 2
 */