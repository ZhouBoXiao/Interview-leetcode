package _题型分类._动态规划._买卖股票的最佳时机;

/**
 * @Description:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * @Author:boxiao
 * @Data: 2020/5/24 22:37
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < prices.length; i++) {
            pre = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i] );
            dp_1 = Math.max(dp_1, pre - prices[i]);
        }
        return dp_0;
    }

}