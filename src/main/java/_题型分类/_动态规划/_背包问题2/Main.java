package _题型分类._动态规划._背包问题2;

/**
 * @Description:  二进制优化
 * @Author: boxiao
 * @Date: 2020/9/7 19:51
 */

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W = sc.nextInt();
        int w, v, s;
        int[] dp = new int[W + 1];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            w = sc.nextInt();
            v = sc.nextInt();
            s = sc.nextInt();

            for (int k = 1; k <= s ; k *= 2) {
                s -= k;
                list.add(new int[]{v * k, w * k});
            }
            if (s > 0) list.add(new int[]{ v * s, w * s});

        }

        for (int[] l : list) {
            for (int j = W; j >= l[1]; j--) {

                dp[j] = Math.max(dp[j], dp[j - l[1]] + l[0]);
            }
        }


        System.out.println(dp[W]);
    }
}
