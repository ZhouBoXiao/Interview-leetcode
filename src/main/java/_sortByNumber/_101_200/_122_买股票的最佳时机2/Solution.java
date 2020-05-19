package _sortByNumber._101_200._122_买股票的最佳时机2;

import java.util.Optional;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }
        return dp_i_0;
    }
    public int maxProfit1(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i >= 1 && prices[i] > prices[i - 1]) {
                result = result + prices[i] - prices[i - 1];
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] prices = new int[]{
                6,1,3,2,4,7
        };
        Optional.of(new Solution().maxProfit(prices)).ifPresent(System.out::println);
    }
}
