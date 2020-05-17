package _公司笔试.leetcode._189_周赛._5399_数位成本和为目标值的最大数字;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

/**
 * @Description:
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 *
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。

 * @Author:boxiao
 * @Data: 2020/5/17 15:15
 */
public class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target+1];
        Arrays.fill(dp, "-");
        dp[0]="";
        for (int i = 0; i < cost.length; i++) {
            for (int j = cost[i]; j <= target ; j++) {
                //后面的表达式需要dp[j - cost[i]]的值，这个值不能无效
                //例如，包容量为10，选择装入重量为3的数字，那么容量为7的包装满的最大数字应该先有效
                //这样才保证了dp[10]是有效的,这个等式就是为了得到选择装入的时候的最大值进行比较
                if (dp[j - cost[i]].equals("-")) continue;
                //包容量为j, 不选择或选择重量i+1装入包的最大数
                dp[j] = maxStr(dp[j], (i+1) + "" + dp[j - cost[i]]);
            }
        }
        return dp[target].equals("-") ? "0" : dp[target];
    }
    private static String maxStr(String a, String b) {
        if (a == null) return b;
        if (a.length() == b.length()) {
            return a.compareTo(b) > 0 ? a : b;
        }
        return a.length() > b.length() ? a : b;
    }
}
