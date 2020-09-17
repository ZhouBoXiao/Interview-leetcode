package _sortByNumber._101_200._121_买卖股票的最佳时机1;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/10 15:23
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);

        }
        return max;
    }
}
